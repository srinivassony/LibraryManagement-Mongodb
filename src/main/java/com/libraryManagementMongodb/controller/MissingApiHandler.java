package com.libraryManagementMongodb.controller;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import com.libraryManagementMongodb.exceptions.NoSuchApiException;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class MissingApiHandler {

    private final RequestMappingHandlerMapping handlerMapping;

    private final Logger logger = LoggerFactory.getLogger(MissingApiHandler.class);

    public MissingApiHandler(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    // Fetch all registered API endpoints lazily to ensure all routes are loaded
    private Set<String> getRegisteredEndpoints() {
        return handlerMapping.getHandlerMethods().keySet().stream()
                .map(info -> info.getPathPatternsCondition() != null ? info.getPathPatternsCondition().getPatterns()
                        : Collections.emptySet()) // Returns a Set<PathPattern>
                .flatMap(set -> set.stream().map(Object::toString)) // Converts PathPattern to String
                .collect(Collectors.toSet());
    }

    @RequestMapping("/**")
    public void handleUnknownApi(HttpServletRequest request) {
        String requestUri = request.getRequestURI();

        if (!getRegisteredEndpoints().contains(requestUri)) {
            throw new NoSuchApiException("ERROR: API '" + requestUri + "' does not exist!");
        }
    }

    @PostConstruct
    public void logRegisteredEndpoints() {
        logger.info("Registered Endpoints: {}", getRegisteredEndpoints());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        logger.info("API Endpoints Loaded: " + getRegisteredEndpoints());
    }

}
