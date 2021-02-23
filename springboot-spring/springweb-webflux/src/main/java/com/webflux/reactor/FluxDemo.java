package com.webflux.reactor;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

/**
 * 创建Flux
 *
 * @author lovely
 * @version 1.0
 * on 2021/2/5
 */
public class FluxDemo {

	/**
	 * 简单创建方法
	 */
	@Test
	private void staticFlux() {
		// 1、静态方法创建
		Flux.just("aa", "bb").subscribe(System.out::printf);
		Flux.fromIterable(Lists.newArrayList("aa", "bbb")).subscribe(System.out::printf);
	}

	/**
	 * 复杂方法
	 */
	@Test
	private void complexFlux() {
		Random random = new Random();
		Flux.generate(ArrayList::new, (list, sink) -> {
			int value = random.nextInt(100);
			list.add(value);
			sink.next(value);
			if (list.size() == 3) sink.complete();
			return list;
		}).subscribe(System.out::println);

		Flux.create(sink -> {
			for (int i = 0; i < 3; i++) {
				sink.next(i);
			}
			sink.complete();
		}).subscribe(System.out::println);
	}

	/**
	 * buffer
	 */
	@Test
	public void buffer() {
		// 收集元素的最大数量
		Flux.range(1, 100).buffer(20).subscribe(System.out::println);
		// 收集时间间隔。序列的生成是异步的，而转换成 Stream 对象可以保证主线程在序列生成完成之前不会退出，从而可以正确地输出序列中的所有元素。
		Flux.interval(Duration.ofSeconds(1)).take(2).toStream().forEach(System.out::println);
		// bufferUntil会一直收集，直到条件符合
		Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
		// bufferWhile只收集条件符合的元素
		Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);
	}


	@Test
	public void filter() {
		// 对流中包含的元素进行过滤，只留下满足 Predicate 指定条件的元素。
		Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
	}

	@Test
	public void window() {
		// window 操作符的作用类似于 buffer，所不同的是 window 操作符是把当前流中的元素收集到另外的 Flux 序列中，因此返回值类型是 Flux<flux>
		// 输出5个UnicastProcessor 字符
		Flux.range(1, 100).window(20).subscribe(System.out::println);
		// 输出2个UnicastProcessor 字符
		Flux.interval(Duration.ofSeconds(1)).window(Duration.ofSeconds(1)).take(2).toStream().forEach(System.out::println);
	}

	@Test
	public void zipWith() {
		// zipWith 操作符把当前流中的元素与另外一个流中的元素按照一对一的方式进行合并。
		// 在合并时可以不做任何处理，由此得到的是一个元素类型为 Tuple2 的流；也可以通
		// 过一个 BiFunction 函数对合并的元素进行处理，所得到的流的元素类型为该函数的返回值。
		Flux.just("a", "b")
				.zipWith(Flux.just("c", "d"))
				.subscribe(System.out::println);
		Flux.just("a", "b")
				.zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
				.subscribe(System.out::println);
	}
}
