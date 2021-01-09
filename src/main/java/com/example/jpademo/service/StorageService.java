package com.example.jpademo.service;

import com.example.jpademo.entity.StorageFile;
import com.example.jpademo.result.StFileVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class StorageService {
    @PersistenceContext
    private EntityManager entityManager;

    public PageCount<StFileVo> findStFileVo(PageCount<StFileVo> pageCount, String dirName, Date fileUpdateTime) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        // criteriaBuilder.createQuery指定了字段的结果视图
        CriteriaQuery<StFileVo> criteriaQuery = criteriaBuilder.createQuery(StFileVo.class);
        // createQuery.from拥有关联信息的实体类(基础表)
        Root<StorageFile> root = criteriaQuery.from(StorageFile.class);
        // join关联的实体类，方式为inner join
        Join<Object, Object> join = root.join("storageDir", JoinType.INNER);
        Join<Object, Object> join1 = root.join("storagePath", JoinType.INNER);
        Predicate predicate = criteriaBuilder.conjunction();
        List<Expression<Boolean>> expressions = predicate.getExpressions();
        // 设定动态查询条件
        if (fileUpdateTime != null) {
            expressions.add(criteriaBuilder.equal(root.get("fileUpdateTime"), fileUpdateTime));
        }
        if (StringUtils.hasText(dirName)) {
            expressions.add(criteriaBuilder.equal(join.get("dirName"), dirName));
        }
        // select ... from ... where ...
        criteriaQuery.select(criteriaBuilder.construct(StFileVo.class,
                root.get("fileName").alias("fileName"), root.get("fileUpdateTime").alias("fileUpdateTime"),
                join.get("dirName").alias("dirName"), join.get("dirDeep").alias("dirDeep"),
                join1.get("pathNode").alias("pathNode"), join1.get("pathValue").alias("pathValue")))
                .where(predicate);
        // 传入分页参数，查询出需要的记录
        List<StFileVo> stFileVos = entityManager.createQuery(criteriaQuery).setFirstResult(pageCount.first()).setMaxResults(pageCount.max()).getResultList();
        pageCount.setData(stFileVos);
        // 构建joinMap，key和value与root.join的一致
        LinkedHashMap<String,JoinType> joinMap = new LinkedHashMap<String,JoinType>(){{
            put("storageDir",JoinType.INNER);
            put("storagePath",JoinType.INNER);
        }};
        // select count
        Long total = entityManager.createQuery(pageCount.count(criteriaBuilder,predicate,StorageFile.class,joinMap)).getSingleResult();
        pageCount.setTotal(total);
        return pageCount;
    }
}
