package com.backbase.stories;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.backbase.steps.ResearchComputerSteps;

public class StoriesRunner extends JUnitStories{
	
	public StoriesRunner() {
		super();
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new ResearchComputerSteps());
	}

	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("/stories/ComputerResearch.story");
	}
}
