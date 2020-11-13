package org.training.core.actions.training;

import de.hybris.platform.commerceservices.model.process.TestActionProcessModel;
import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAction extends AbstractSimpleDecisionAction<TestActionProcessModel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestAction.class);
    @Override
    public Transition executeAction(TestActionProcessModel testActionProcessModel){
        LOGGER.info("Enter Action Step 1..");
        if(Boolean.TRUE){
            return Transition.OK;
        }
        return Transition.NOK;
    }
}
