package br.org.siege.softplan.exercicio2;

import br.org.siege.softplan.exercicio2.core.CompositionBatchCalculator;
import br.org.siege.softplan.exercicio2.core.dto.CompositionDTO;
import br.org.siege.softplan.exercicio2.core.util.JsonUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MainClass {

    public static void main(String... args) {

        try (InputStream input = new FileInputStream(args[0])) {

            Map<Integer, List<CompositionDTO>> compositionBatchs = JsonUtils.serialize(input);

            CompositionBatchCalculator compositionBatchCalculator = new CompositionBatchCalculator(compositionBatchs);
            String result = compositionBatchCalculator.execute();

            System.out.println(result);

        } catch (Exception e) {
            System.err.println(String.format("Ops..: %s", e.getMessage()));
            System.exit(1);
        }
    }

}
