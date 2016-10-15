package com.backbase.stories;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.backbase.steps.HomePageSteps;
import com.backbase.steps.CreateComputersSteps;

public class AllStories extends JUnitStories {
	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration();
	}
	
	@Override
	public InjectableStepsFactory stepsFactory() {
		List<Object> steps = new ArrayList<>();
		steps.add(new HomePageSteps());
		steps.add(new CreateComputersSteps());
		return new InstanceStepsFactory(configuration(), steps);
	}

	@Override
	protected List<String> storyPaths() {
		List<String> paths = new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), "**/*.story", "");				
		return paths;
	}
}
