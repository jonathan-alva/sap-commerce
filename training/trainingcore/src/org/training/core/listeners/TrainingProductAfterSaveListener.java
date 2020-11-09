package org.training.core.listeners;

import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.tx.AfterSaveEvent;
import de.hybris.platform.tx.AfterSaveListener;
import de.hybris.platform.workflow.WorkflowProcessingService;
import de.hybris.platform.workflow.WorkflowService;
import de.hybris.platform.workflow.WorkflowTemplateService;
import org.training.core.enums.ActiveStatus;
import org.training.core.event.TestEvent;
import org.training.core.model.TrainingVariantProductModel;

import java.util.Collection;

public class TrainingProductAfterSaveListener implements AfterSaveListener {

    private ModelService modelService;
    private EventService eventService;
    private BaseSiteService baseSiteService;
    private CommonI18NService commonI18NService;
    private UserService userService;
    private FlexibleSearchService flexibleSearchService;
    private WorkflowService workflowService;
    private WorkflowTemplateService workflowTemplateService;
    private WorkflowProcessingService workflowProcessingService;

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public BaseSiteService getBaseSiteService() {
        return baseSiteService;
    }

    public void setBaseSiteService(BaseSiteService baseSiteService) {
        this.baseSiteService = baseSiteService;
    }

    public CommonI18NService getCommonI18NService() {
        return commonI18NService;
    }

    public void setCommonI18NService(CommonI18NService commonI18NService) {
        this.commonI18NService = commonI18NService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    public WorkflowService getWorkflowService() {
        return workflowService;
    }

    public void setWorkflowService(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    public WorkflowTemplateService getWorkflowTemplateService() {
        return workflowTemplateService;
    }

    public void setWorkflowTemplateService(WorkflowTemplateService workflowTemplateService) {
        this.workflowTemplateService = workflowTemplateService;
    }

    public WorkflowProcessingService getWorkflowProcessingService() {
        return workflowProcessingService;
    }

    public void setWorkflowProcessingService(WorkflowProcessingService workflowProcessingService) {
        this.workflowProcessingService = workflowProcessingService;
    }

    @Override
    public void afterSave(Collection<AfterSaveEvent> events) {
        events.forEach(items -> {
            final PK pk = items.getPk();
            if (1 == pk.getTypeCode()) {
                ProductModel productModel = getProductForPk(pk);
                if (productModel instanceof TrainingVariantProductModel) {
                    TrainingVariantProductModel product = (TrainingVariantProductModel) productModel;
                    if(product.getActiveStatus().equals(ActiveStatus.SOLDOUT)){
                        getEventService().publishEvent(initializeTestEvent(product, new TestEvent()));
                    }
                }
            }
        });
    }
    private ProductModel getProductForPk(final PK pk){
        return getModelService().get(pk);
    }

    private TestEvent initializeTestEvent(TrainingVariantProductModel productModel, TestEvent event){
        event.setSite(getBaseSiteService().getAllBaseSites().iterator().next());
        event.setLanguage(getCommonI18NService().getCurrentLanguage());
        event.setProductModel(productModel);
        return event;
    }
}
