package com.questhelper.quests.balloonflights;

import com.questhelper.questhelpers.QuestHelper;
import java.util.ArrayList;
import java.util.Arrays;

public class BalloonFlightCraftingGuild extends BalloonFlight
{
	public BalloonFlightCraftingGuild(QuestHelper questHelper)
	{
		super(questHelper, "Navigate the balloon to the Crafting Guild.");
	}

	@Override
	protected void setupSteps()
	{
		super.setupSteps();

		section1 = new ArrayList<>();

		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(9);
		section1.add(10);
		section1.add(10);
		section1.add(10);
		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(9);
		section1.add(7);
		section1.add(7);
		section1.add(7);
		section1.add(6);
		section1.add(6);
		section1.add(7);

		section2 = new ArrayList<>();

		section1.add(7);
		section1.add(7);
		section1.add(6);
		section1.add(6);
		section1.add(7);
		section1.add(7);
		section1.add(7);
		section1.add(7);
		section1.add(7);
		section1.add(6);
		section1.add(6);
		section1.add(6);
		section1.add(6);
		section1.add(7);
		section1.add(7);
		section1.add(7);
		section1.add(7);
		section1.add(7);
		section1.add(7);

		section3 = new ArrayList<>();
		// Not gone to

		section1.add(7);
		section1.add(7);
		section1.add(7);
		section1.add(9);
		section1.add(9);
		section1.add(9);
		section1.add(9);
		section1.add(9);
		section1.add(9);
		section1.add(9);
		section1.add(7);
		section1.add(7);
		section1.add(7);
		section1.add(7);
		section1.add(6);
		section1.add(6);
		section1.add(6);
		section1.add(6);

		sections = new ArrayList<>(Arrays.asList(section1, section2, section3));
	}
}
