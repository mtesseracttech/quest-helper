package com.questhelper.quests.balloonflights;

import com.questhelper.questhelpers.QuestHelper;
import com.questhelper.steps.DetailedOwnerStep;
import com.questhelper.steps.QuestStep;
import com.questhelper.steps.WidgetStep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.eventbus.Subscribe;

public abstract class BalloonFlight extends DetailedOwnerStep
{
	WidgetStep dropSand, burnLog, pullRope, pullRedRope, goStraight;

	// Current position, next position
	protected ArrayList<Integer> section1;
	protected ArrayList<Integer> section2;
	protected ArrayList<Integer> section3;

	protected ArrayList<ArrayList<Integer>> sections;

	public BalloonFlight(QuestHelper questHelper, String flightDescription)
	{
		super(questHelper, flightDescription);
	}

	@Override
	protected void setupSteps()
	{
		dropSand = new WidgetStep(getQuestHelper(),  "Drop a sandbag.", 471, 17);
		burnLog = new WidgetStep(getQuestHelper(),  "Burn a log.", 471, 24);
		pullRope = new WidgetStep(getQuestHelper(),  "Pull the brown rope.", 471, 6);
		pullRedRope = new WidgetStep(getQuestHelper(),  "Pull the red rope.", 471, 9);
		goStraight = new WidgetStep(getQuestHelper(),  "Press relax.", 471, 27);
	}

	@Subscribe
	@Override
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		super.onVarbitChanged(varbitChanged);
		updateSteps();
	}

	protected void updateSteps()
	{
		int section = client.getVarbitValue(2884) - 1;
		int xPos = client.getVarbitValue(2882);
		int yPos = client.getVarbitValue(2883);

		// If we've gone to next section before updating the pos, return
		if (sections.get(section).size() <= xPos + 1)
		{
			return;
		}
		int diffBetweenCurrentAndNextPos = sections.get(section).get(xPos + 1) - yPos;

		if (diffBetweenCurrentAndNextPos == 0)
		{
			startUpStep(goStraight);
		}
		else if (diffBetweenCurrentAndNextPos == 1)
		{
			startUpStep(burnLog);
		}
		else if (diffBetweenCurrentAndNextPos > 1)
		{
			startUpStep(dropSand);
		}
		else if (diffBetweenCurrentAndNextPos == -1)
		{
			startUpStep(pullRope);
		}
		else
		{
			startUpStep(pullRedRope);
		}
	}

	@Override
	public Collection<QuestStep> getSteps()
	{
		return Arrays.asList(dropSand, burnLog, pullRope, pullRedRope, goStraight);
	}
}
