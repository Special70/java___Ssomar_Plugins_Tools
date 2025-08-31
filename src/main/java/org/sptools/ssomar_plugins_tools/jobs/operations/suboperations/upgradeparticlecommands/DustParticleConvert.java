package org.sptools.ssomar_plugins_tools.jobs.operations.suboperations.upgradeparticlecommands;

import org.sptools.ssomar_plugins_tools.jobs.utility.JobState;

public class DustParticleConvert {
    public static void run(JobState jobState, StringBuilder strBuilder, String word) {
        switch (jobState.iteration) {
            case 0: {
                strBuilder.append("{color:[").append(Float.valueOf(word));
                jobState.iteration += 1;
                return;
            }
            case 1: {
                strBuilder.append(",").append(Float.valueOf(word));
                jobState.iteration += 1;
                return;
            }
            case 2: {
                strBuilder.append(",").append(Float.valueOf(word)).append("],scale:");
                jobState.iteration += 1;
                return;
            }
            case 3: {
                strBuilder.append(Float.valueOf(word)).append("}");
                jobState.iteration = 0;
                jobState.isGatheringData = false;
                jobState.isInspectingParticleType = false;
                return;
            }
        }

    }
}
