package com.webflux.reactor;

import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * 创建Mono
 *
 * @author lovely
 * @version 1.0
 * on 2021/2/5
 */
public class CreateMonoDemo {

	private void staticMono() {
		// 1、静态方法创建
		Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
		Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
		Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
	}

	public static void main(String[] args) {
		CreateMonoDemo monoDemo = new CreateMonoDemo();

		monoDemo.staticMono();
	}
}
