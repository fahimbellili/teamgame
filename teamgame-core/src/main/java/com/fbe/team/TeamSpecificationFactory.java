package com.fbe.team;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TeamSpecificationFactory {

    public static Specification<Team> getTeams(String name, String acronym, Double budget) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(name)) {
                Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
                predicates.add(namePredicate);
            }

            if (StringUtils.hasText(acronym)) {
                Predicate acronymPredicate = criteriaBuilder.equal(root.get("acronym"), "%" + acronym + "%");
                predicates.add(acronymPredicate);
            }

            if (budget != null) {
                Predicate budgetPredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("budget"), budget);
                predicates.add(budgetPredicate);
            }

            query.distinct(true);
            query.orderBy(criteriaBuilder.asc(root.get("name")));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
