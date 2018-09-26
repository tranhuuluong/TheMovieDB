package com.tranhuuluong.themoviedb.repository.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luongtran on 9/25/18.
 */

public abstract class ModelMapper<MODEL, ENTITY> {

    public abstract MODEL transform(ENTITY entity);

    public List<MODEL> transform(List<ENTITY> entities) {
        List<MODEL> modelList = new ArrayList<>();
        if (entities != null && !entities.isEmpty()) {
            for (ENTITY entity : entities) {
                modelList.add(transform(entity));
            }
        }

        return modelList;
    }
}
