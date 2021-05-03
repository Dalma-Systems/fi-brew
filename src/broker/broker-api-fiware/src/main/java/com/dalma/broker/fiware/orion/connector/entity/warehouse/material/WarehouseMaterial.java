package com.dalma.broker.fiware.orion.connector.entity.warehouse.material;

import com.dalma.broker.fiware.orion.connector.entity.BaseOrionEntity;
import com.dalma.broker.fiware.orion.connector.entity.OrionEntity;
import com.dalma.broker.fiware.orion.connector.entity.attribute.OrionAttribute;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class WarehouseMaterial extends BaseOrionEntity implements OrionEntity, Serializable {

    private static final long serialVersionUID = -3685417741726067603L;
    public static final String ENTITY_TYPE = "Material";

    private OrionAttribute<String> mType;
    private OrionAttribute<String> batch;
    private OrionAttribute<Double> quantity;
    private OrionAttribute<String> unit;
    private OrionAttribute<String> refWarehouse;
    private OrionAttribute<String> erpId;

    @Override
    public String getEntityType() {
        return ENTITY_TYPE;
    }
}
