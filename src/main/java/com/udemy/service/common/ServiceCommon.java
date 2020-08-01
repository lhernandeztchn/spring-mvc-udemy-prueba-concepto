package com.udemy.service.common;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class ServiceCommon<T> {
	protected T base;
	protected Optional<T> object;
}