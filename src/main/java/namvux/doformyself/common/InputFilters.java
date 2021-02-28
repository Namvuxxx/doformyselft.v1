package namvux.doformyself.common;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter

public class InputFilters {
    private List<SearchCriteria> criteria = new ArrayList<>();

    public  InputFilters(String condition) {
        if (condition != null) {
            String regex = "(\\w+?)(=|>|>=|<|<=|start|end|include)(\\w+?),";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(condition + ",");
            while (matcher.find()) {
                criteria.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }

        }
    }
}
