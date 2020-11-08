package org.training.storefront.controllers.pages;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.core.model.product.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.training.core.service.TrainingProductService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductRecommendationPageController extends ProductPageController {
    private static final String PRODUCT_RECOMMENDATION_PAGE = "product-recommendation";

    @Resource(name = "defaultTrainingProductService")
    private TrainingProductService productService;



    @RequestMapping(value = PRODUCT_RECOMMENDATION_PAGE, method = RequestMethod.GET)
    public String getPriceEngine(final Model model) throws CMSItemNotFoundException {
        final ContentPageModel contentPageModel = getContentPageForLabelOrId(PRODUCT_RECOMMENDATION_PAGE);
        storeCmsPageInModel(model, contentPageModel);
        setUpMetaDataForContentPage(model, contentPageModel);

        List<ProductModel> productModelList = productService.getAllProductModels();

        model.addAttribute("productList", productModelList);

        return getViewForPage(model);
    }
}
