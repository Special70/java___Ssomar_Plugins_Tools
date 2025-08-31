package org.sptools.ssomar_plugins_tools.jobs.operations.suboperations.upgradeparticlecommands;

import org.sptools.ssomar_plugins_tools.jobs.utility.JobState;

public class ItemParticleConvert {

    public static void run(JobState jobState, StringBuilder strBuilder, String word) {
        // reference 1.20.5+ item particle: "item{item:"cake"}"
        switch (jobState.iteration) {
            case 0: {
                strBuilder.append("{item:[").append(word);
                jobState.iteration += 1;
                return;
            }
            case 1: {
                strBuilder.append("\"}").append(Float.valueOf(word));
                jobState.iteration = 0;
                jobState.isGatheringData = false;
                jobState.isInspectingParticleType = false;
                return;
            }
        }

    }
}