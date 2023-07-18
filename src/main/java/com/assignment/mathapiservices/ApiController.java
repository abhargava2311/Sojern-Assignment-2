package com.assignment.mathapiservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	static List<Integer> list = new ArrayList<>(Arrays.asList(7, 19, 14, 1, 12, 22, 18, 3, 28, 5));

	@GetMapping("/min")
	public int getMin() {
		return list.stream().min(Integer::compare).get();

	}

	@GetMapping("/max")
	public int getMax() {
		return list.stream().max(Integer::compare).get();

	}

	@GetMapping("/avg")
	public double getAvg() {
		return (double) list.stream().mapToDouble(a -> a).average().orElse(0);

	}

	@GetMapping("/median")
	public int getMedian() {

		int middle = list.size() / 2;
		return list.stream().filter(i -> list.indexOf(i) == middle).collect(Collectors.toList()).get(0);

	}

}
