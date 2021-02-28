package namvux.doformyself.common;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@AllArgsConstructor
public class EntitySpecification<T> implements Specification<T> {
    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        switch (criteria.getOperation()) {
            case "=":
                return criteriaBuilder.equal(root.<String>get(criteria.getKey()), criteria.getValue());
            case ">":
                return criteriaBuilder.greaterThan(root.<String>get(criteria.getKey()), criteria.getValue());
            case ">=":
                return criteriaBuilder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue());
            case "<":
                return criteriaBuilder.lessThan(root.<String>get(criteria.getKey()), criteria.getValue());
            case "<=":
                return criteriaBuilder.lessThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue());
            case "start":
                return criteriaBuilder.like(root.<String>get(criteria.getKey()), criteria.getValue() + "%");
            case "end":
                return criteriaBuilder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue());
            case "include":
                return criteriaBuilder.equal(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            default:
                return null;
        }

    }

}
