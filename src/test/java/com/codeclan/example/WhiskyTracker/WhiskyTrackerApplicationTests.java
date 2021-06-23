package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> found = whiskyRepository.findByYear(2018);
		assertEquals(6, found.size());
	}

	@Test
	public void canFindDistilleryByRegion() {
		List<Distillery> found = distilleryRepository.findByRegion("Island");
		assertEquals(3, found.size());
	}

	@Test
	public void canFindWhiskyByAgeAndDistillery() {
		Optional<Distillery> foundDistillery = distilleryRepository.findById(2L);
		List<Whisky> foundWhisky = whiskyRepository.findByAgeAndDistillery(12, foundDistillery);
		assertEquals(1, foundWhisky.size());
	}

	@Test
	public void canFindWhiskyByRegion() {
		List<Whisky> foundWhisky = whiskyRepository.findByDistilleryRegion("Lowland");
		assertEquals(4, foundWhisky.size());
	}

	@Test
	public void canFindDistilleryByWhiskyAge12() {
		List<Distillery> foundDistillery = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(6, foundDistillery.size());
	}
}
