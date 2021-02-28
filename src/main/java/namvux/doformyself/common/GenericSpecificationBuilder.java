package namvux.doformyself.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class GenericSpecificationBuilder<T> {

    private final List<SearchCriteria> params;

    public GenericSpecificationBuilder(String condition) {
        this.params = new InputFilters(condition).getCriteria();
    }

    public Specification<T> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<T>> specifications = params.stream()
                .map(EntitySpecification<T>::new)
                .collect(Collectors.toList());

        Specification<T> result = specifications.get(0);

        for(int i = 0; i< params.size(); i++){
            result = Specification.where(result).and(specifications.get(i));
        }

        return result;

    }

}
