package org.sptools.ssomar_plugins_tools.jobs.utility;

/**
 * Helps the code know how to format incoming word reads.
 * For example, the dust particle type and the block particle type has different arguments,
 * meaning, the code has to convert formats differently.
 * <br /><br />
 * This class is made to store primitive datatype variables and be able to provide
 * sub-operations a pointer to those variables
 */
public class JobState {
    public String gatherType = "";
    public int iteration = 0;
    public boolean isInspectingParticleType = false;
    public boolean isGatheringData = false; // for knowing whether to start recording data differently or not
}