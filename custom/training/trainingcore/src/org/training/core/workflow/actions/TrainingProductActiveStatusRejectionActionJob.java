package org.training.core.workflow.actions;

import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.workflow.model.WorkflowActionModel;
import de.hybris.platform.workflow.model.WorkflowDecisionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class TrainingProductActiveStatusRejectionActionJob extends AbstractTrainingProductActionStatusApprovalActionJob{
    @Resource(name="modelService")
    private ModelService modelService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TrainingProductActiveStatusRejectionActionJob.class);

    @Override
    public WorkflowDecisionModel perform(final WorkflowActionModel action){
        LOGGER.info("Enterd into Training Product Active Status Rejection Action Job");
        return rejectProductAndFetchDecision(action);
    }
}
