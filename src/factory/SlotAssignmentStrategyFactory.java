package factory;

import models.SlotAssignmentStrategyType;
import service.RandomSlotAssignmentStrategy;
import service.SlotAssignmentStrategy;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotAssignmentStrategy(SlotAssignmentStrategyType slotAssignmentStrategyType){
        return new RandomSlotAssignmentStrategy();
    }
}
