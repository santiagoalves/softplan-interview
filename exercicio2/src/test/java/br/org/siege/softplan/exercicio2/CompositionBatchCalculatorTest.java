package br.org.siege.softplan.exercicio2;

import br.org.siege.softplan.exercicio2.core.CompositionBatchCalculator;
import br.org.siege.softplan.exercicio2.core.dto.CompositionDTO;
import br.org.siege.softplan.exercicio2.core.util.JsonUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CompositionBatchCalculatorTest {

    @Test
    public void deve_calcular_precos_corretamente_para_insumos_e_composicoes_informados_via_arquivo() throws IOException {

        try (InputStream input = this.getClass().getClassLoader().getResourceAsStream("input.json")) {

            Map<Integer, List<CompositionDTO>> compositionBatchs = JsonUtils.serialize(input);

            CompositionBatchCalculator compositionBatchCalculator = new CompositionBatchCalculator(compositionBatchs);

            String result = compositionBatchCalculator.execute();

            Path reultFilePath = Paths.get(Objects.requireNonNull(this.getClass().getClassLoader().getResource("output.txt")).getFile());
            String expectedOutput = String.join("\n", Files.readAllLines(reultFilePath));

            Assert.assertEquals(expectedOutput, result);
        }
    }

}
