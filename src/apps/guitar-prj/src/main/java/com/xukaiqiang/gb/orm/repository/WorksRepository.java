package com.xukaiqiang.gb.orm.repository;

import static com.xukaiqiang.shared.util.JpaSpecUtils.*;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xukaiqiang.gb.orm.entity.Works;
import com.xukaiqiang.gb.orm.protocol.WorksFilterRequest;

public interface WorksRepository extends JpaRepository<Works, Integer>, JpaSpecificationExecutor<Works> {

	public static class Executor {
		private WorksRepository repository;

		public Executor(WorksRepository repository) {
			this.repository = repository;
		}

		public Page<Works> findAll(final WorksFilterRequest filter, Pageable pageable) {
			return repository.findAll(new Specification<Works>() {
				@Override
				public Predicate toPredicate(Root<Works> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					if (filter == null) {
						return cb.conjunction();
					}

					return cb.and(merge(

							//TODO

					));
				}
			}, pageable);
		}

		public List<Works> findAll(final WorksFilterRequest filter) {
			return repository.findAll(new Specification<Works>() {
				@Override
				public Predicate toPredicate(Root<Works> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					if (filter == null) {
						return cb.conjunction();
					}

					return cb.and(merge(

							//TODO

					));
				}
			});
		}

		public Works findOne(final WorksFilterRequest filter) {
			return repository.findOne(new Specification<Works>() {
				@Override
				public Predicate toPredicate(Root<Works> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					if (filter == null) {
						return cb.conjunction();
					}

					return cb.and(merge(

							//TODO

					));
				}
			});
		}

	}

}
