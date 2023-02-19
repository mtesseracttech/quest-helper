package com.questhelper.quests.balloonflights;

import com.questhelper.QuestDescriptor;
import com.questhelper.QuestHelperQuest;
import com.questhelper.Zone;
import com.questhelper.panel.PanelDetails;
import com.questhelper.questhelpers.BasicQuestHelper;
import com.questhelper.requirements.Requirement;
import com.questhelper.requirements.ZoneRequirement;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.player.SkillRequirement;
import com.questhelper.requirements.quest.QuestRequirement;
import com.questhelper.requirements.var.VarbitRequirement;
import com.questhelper.requirements.widget.WidgetTextRequirement;
import com.questhelper.rewards.ExperienceReward;
import com.questhelper.steps.ConditionalStep;
import com.questhelper.steps.DetailedOwnerStep;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.NpcStep;
import com.questhelper.steps.QuestStep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;

@QuestDescriptor(
	quest = QuestHelperQuest.BALLOON_FLIGHTS
)
public class BalloonFlights extends BasicQuestHelper
{
	ItemRequirement oakLogs10, willowLogs10, yewLogs10, magicLogs3;

	Requirement enlightenedJourney;

	Requirement onEntrana, flying;

	Requirement notFlownToCraftingGuild, notFlownToLumberYard, notFlownToCastleWars, notFlownToGrandTree;

	Zone entrana;

	NpcStep travelToEntrana, talkToAuguste;

	QuestStep flyToCraftingGuild, flyToLumberYard, flyToCastleWars, flyToGrandTree;

	DetailedOwnerStep craftingGuildPuzzle, lumberYardPuzzle, castleWarsPuzzle, grandTreePuzzle;


	@Override
	public void setupRequirements()
	{
		// Finished flight, 2868 = 1
		notFlownToCraftingGuild = new VarbitRequirement(2867, 0);
		notFlownToLumberYard = new VarbitRequirement(2868, 0);
		notFlownToCastleWars = new VarbitRequirement(2869, 0);
		notFlownToGrandTree = new VarbitRequirement(2870, 0);

		oakLogs10 = new ItemRequirement("Oak Logs", ItemID.OAK_LOGS, 10);
		willowLogs10 = new ItemRequirement("Willow Logs", ItemID.WILLOW_LOGS, 10);
		yewLogs10 = new ItemRequirement("Yew Logs", ItemID.YEW_LOGS, 10);
		magicLogs3 = new ItemRequirement("Magic Logs", ItemID.MAGIC_LOGS, 3);

		enlightenedJourney = new QuestRequirement(QuestHelperQuest.ENLIGHTENED_JOURNEY, QuestState.FINISHED);
	}

	@Override
	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(oakLogs10, willowLogs10, yewLogs10, magicLogs3);
	}

	@Override
	public List<Requirement> getGeneralRequirements()
	{
		List<Requirement> reqs = new ArrayList<>();
		reqs.add(new SkillRequirement(Skill.FIREMAKING, 60));
		reqs.add(enlightenedJourney);
		return reqs;
	}

	@Override
	public List<ExperienceReward> getExperienceRewards()
	{
		return Arrays.asList(new ExperienceReward(Skill.FIREMAKING, 8000));
	}

	public void setupZones()
	{
		entrana = new Zone(new WorldPoint(2798, 3327, 0), new WorldPoint(2878, 3394, 1));
	}

	public void setupConditions()
	{
		onEntrana = new ZoneRequirement(entrana);

		flying = new WidgetTextRequirement(471, 1, "Balloon Controls");
	}

	public void setupSteps()
	{
		travelToEntrana = new NpcStep(this, NpcID.MONK_OF_ENTRANA_1167, new WorldPoint(3048, 3236, 0),
			"Speak with a monk to travel to Entrana.", true);
		travelToEntrana.addAlternateNpcs(NpcID.MONK_OF_ENTRANA_1166, NpcID.MONK_OF_ENTRANA);
		talkToAuguste = new NpcStep(this, NpcID.AUGUSTE, new WorldPoint(2810, 3356, 0),
			"Speak with Auguste and travel to Castle Wars.");

		flyToCraftingGuild = new DetailedQuestStep(this, "Fly to crafting guild", oakLogs10.highlighted());
		craftingGuildPuzzle = new BalloonFlightCraftingGuild(this);

		flyToLumberYard = new DetailedQuestStep(this, "Fly to Lumber Yard", willowLogs10.highlighted());
		lumberYardPuzzle = new BalloonFlightLumberYard(this);

		flyToCastleWars = new DetailedQuestStep(this, "Fly to Castle Wars", yewLogs10.highlighted());
		castleWarsPuzzle = new BalloonFlightCastleWars(this);

		flyToGrandTree = new DetailedQuestStep(this, "Fly to Grand Tree", magicLogs3.highlighted());
		grandTreePuzzle = new BalloonFlightGrandTree(this);
	}

	@Override
	public ArrayList<PanelDetails> getPanels()
	{
		ArrayList<PanelDetails> allSteps = new ArrayList<>();

		PanelDetails craftingGuildSteps = new PanelDetails(
			"Fly to Crafting Guild",
			Collections.singletonList(flyToCraftingGuild),
			new SkillRequirement(Skill.FIREMAKING, 30)
		);
		craftingGuildSteps.setDisplayCondition(notFlownToCraftingGuild);
		craftingGuildSteps.setLockingStep(craftingGuildPuzzle);
		allSteps.add(craftingGuildSteps);

		PanelDetails lumberYardSteps = new PanelDetails(
			"Fly to Varrock Lumber Yard",
			Collections.singletonList(flyToLumberYard),
			new SkillRequirement(Skill.FIREMAKING, 40)
		);
		lumberYardSteps.setDisplayCondition(notFlownToLumberYard);
		lumberYardSteps.setLockingStep(lumberYardPuzzle);
		allSteps.add(lumberYardSteps);

		PanelDetails castleWarsSteps = new PanelDetails(
			"Fly to Castle Wars",
			Collections.singletonList(flyToCastleWars),
			new SkillRequirement(Skill.FIREMAKING, 50)
		);
		castleWarsSteps.setDisplayCondition(notFlownToCastleWars);
		castleWarsSteps.setLockingStep(castleWarsPuzzle);
		allSteps.add(castleWarsSteps);

		PanelDetails grandTreeSteps = new PanelDetails(
			"Fly to Grand Tree",
			Collections.singletonList(flyToGrandTree),
			new SkillRequirement(Skill.FIREMAKING, 60)
		);
		grandTreeSteps.setDisplayCondition(notFlownToGrandTree);
		grandTreeSteps.setLockingStep(grandTreePuzzle);
		allSteps.add(grandTreeSteps);

		return allSteps;
	}

	@Override
	public Map<Integer, QuestStep> loadSteps()
	{
		setupRequirements();
		setupZones();
		setupConditions();
		setupSteps();

		Map<Integer, QuestStep> steps = new HashMap<>();

		steps.put(0, CreateFlightStep(oakLogs10, flyToCraftingGuild, craftingGuildPuzzle));

		steps.put(1, CreateFlightStep(willowLogs10, flyToLumberYard, lumberYardPuzzle));

		steps.put(2, CreateFlightStep(yewLogs10, flyToCastleWars, castleWarsPuzzle));

		steps.put(3, CreateFlightStep(magicLogs3, flyToGrandTree, grandTreePuzzle));

		return steps;
	}

	private QuestStep CreateFlightStep(Requirement logRequirement, QuestStep flight, DetailedOwnerStep puzzle)
	{
		ConditionalStep balloonFlightStep = new ConditionalStep(this, travelToEntrana);
		balloonFlightStep.addStep(onEntrana, talkToAuguste);
		balloonFlightStep.addStep(logRequirement, flight);
		balloonFlightStep.addStep(flying, puzzle);
		return balloonFlightStep;
	}
}
