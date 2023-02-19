/*
 * Copyright (c) 2021, Zoinkwiz <https://github.com/Zoinkwiz>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.questhelper.quests.enlightenedjourney;

import com.questhelper.questhelpers.QuestHelper;
import com.questhelper.quests.balloonflights.BalloonFlight;
import java.util.ArrayList;
import java.util.Arrays;

public class BalloonFlightTaverley extends BalloonFlight
{
	public BalloonFlightTaverley(QuestHelper questHelper)
	{
		super(questHelper, "Navigate the balloon to Taverley.");
	}

	@Override
	protected void setupSteps()
	{
		super.setupSteps();

		section1 = new ArrayList<>();
		section1.add(5);
		// Drop sandbag
		section1.add(7);
		// Burn log
		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(8);
		section1.add(8);
		// Drop down 2
		section1.add(6);
		section1.add(6);
		section1.add(6);
		// Drop down 1
		section1.add(5);
		section1.add(5);
		section1.add(5);
		section1.add(5);
		section1.add(5);
		// Off screen
		section1.add(5);

		section2 = new ArrayList<>();
		// Not gone to
		section2.add(5);
		section2.add(5);
		// Burn log
		section2.add(6);
		section2.add(6);
		// Burn log
		section2.add(7);
		section2.add(7);
		section2.add(7);
		section2.add(7);
		section2.add(7);
		section2.add(7);
		section2.add(7);
		section2.add(7);
		section2.add(7);
		section2.add(7);
		section2.add(7);
		// Burn log
		section2.add(8);
		section2.add(8);
		section2.add(8);
		section2.add(8);
		section2.add(8);
		// Off screen
		section2.add(8);

		section3 = new ArrayList<>();
		// Not gone to
		section3.add(8);

		section3.add(8);
		section3.add(8);
		section3.add(8);
		section3.add(8);
		section3.add(8);
		section3.add(8);
		section3.add(8);
		section3.add(8);
		section3.add(6);
		section3.add(5);
		section3.add(5);
		section3.add(5);
		section3.add(5);
		section3.add(6);
		section3.add(6);
		section3.add(6);
		section3.add(6);
		section3.add(6);
		section3.add(5);
		section3.add(5);

		sections = new ArrayList<>(Arrays.asList(section1, section2, section3));
	}
}
