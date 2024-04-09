package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class demoController {
	@GetMapping(value = "/gethi")
	public String seyHello() {
		return "Hello";
	}

	@GetMapping(value = "/add/{a}/{b}")
	public int add(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}

	@GetMapping(value = "/rev/{a}")
	public String rev(@PathVariable String a) {
		String temp = "";
		for (int i = 0; i < a.length(); i++) {
			temp = a.charAt(i) + temp;
		}
		return temp;
	}

	@GetMapping(value = "/palindrome/{input}")
	public String palin(@PathVariable int input) {
		int org = input;
		int temp = 0;
		while (input > 0) {
			int rem = input % 10;
			temp = (temp * 10) + rem;
			input = input / 10;
		}
		if (org == temp) {
			return "Palindrome";
		} else {
			return "Not Palindrome";
		}
	}

	@GetMapping(value = "/prime/{a}")
	public String prime(@PathVariable int a) {
		int count = 0;
		for (int i = 2; i < a; i++) {
			if (a / i == 0) {
				count++;
			}
		}
		if (count == 0) {
			return "Prime";
		} else {
			return "Not Prime";
		}
	}

	@GetMapping(value = "/count/{a}")
	public int primeCount(@PathVariable int a) {
		int temp = 0;
		for (int i = 1; i <= a; i++) {
			int count = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			if (count == 0) {
				temp++;
			}
		}
		return temp;
	}

	@GetMapping(value = "/div7/{a}")
	public List<Integer> divisible7(@PathVariable int a) {
		List<Integer> arr = new ArrayList<>();
		for (int i = 1; i < a; i++) {
			if (i % 7 == 0) {
				arr.add(i);
			}
		}
		return arr;
	}

	@GetMapping(value = "/cwc/{str}")
	public Map<Character, Long> chatWcount(@PathVariable String str) {
		Map<Character, Long> arr = str.chars().mapToObj(x -> (char) x)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return arr;
	}

	@GetMapping(value = "/dwc/{str}")
	public Map<Character, Long> dubWcount(@PathVariable String str) {
		Map<Character, Long> arr = str.chars().mapToObj(x -> (char) x)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Character, Long> res = arr.keySet().stream().filter(x -> arr.get(x) > 1)
				.collect(Collectors.toMap(x -> x, y -> arr.get(y)));
		return res;
	}

	@GetMapping(value = "/ndwc")
	public Map<Character, Long> nondubWcount(@RequestParam String str) {
		Map<Character, Long> arr = str.chars().mapToObj(x -> (char) x)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Character, Long> res = arr.keySet().stream().filter(x -> arr.get(x) == 1)
				.collect(Collectors.toMap(x -> x, y -> arr.get(y)));
		return res;
	}
}
