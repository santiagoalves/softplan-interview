package br.org.siege.softplan.exercicio2.core.util;

import br.org.siege.softplan.exercicio2.core.dto.CompositionDTO;
import br.org.siege.softplan.exercicio2.core.exception.InputParseFailedExecption;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final TypeReference typRef = new TypeReference<List<CompositionDTO>>() {
    };

    private JsonUtils() {}

    public static List<CompositionDTO> readToCompositiontDtoList(final InputStream input) {
        try {
            return mapper.readValue(input, typRef);
        } catch (IOException e) {
            throw new InputParseFailedExecption("Parsing from json input failed", e);
        }
    }

    public static Map<Integer, List<CompositionDTO>> serialize(InputStream input) {
        return JsonUtils.readToCompositiontDtoList(input).stream()
                .collect(Collectors.groupingBy(CompositionDTO::getCodigoComposicao, LinkedHashMap::new, Collectors.toList()));
    }



}
