package org.training.core.service.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.impl.DefaultProductService;
import org.training.core.dao.TrainingProductDao;
import org.training.core.service.TrainingProductService;

import javax.annotation.Resource;
import java.util.List;

public class DefaultTrainingProductService extends DefaultProductService implements TrainingProductService {

    @Resource(name = "defaultTrainingProductDao")
    private TrainingProductDao trainingProductDao;

    @Override
    public List<ProductModel> getAllProductModels() {
        return trainingProductDao.getAllProductModels();
    }
}
