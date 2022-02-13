package lukyanov.task.arrays;

import lukyanov.task.arrays.entity.ArrayEntity;
import lukyanov.task.arrays.exception.CustomException;
import lukyanov.task.arrays.parser.FileParser;
import lukyanov.task.arrays.repository.Specification;
import lukyanov.task.arrays.repository.impl.ArrayRepositoryImpl;
import lukyanov.task.arrays.repository.impl.SumSpecification;
import lukyanov.task.arrays.service.CustomArrayListService;
import lukyanov.task.arrays.service.impl.CustomRepositoryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final String PATH = "resources/file/numbers.txt";
    private static final Logger logger = LogManager.getLogger(FileParser.class);


    public static void main(String[] args) {
        try {
            ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
            CustomArrayListService service = new CustomArrayListService();
            List<ArrayEntity> list = service.getArrayFromFile(PATH);
            CustomRepositoryServiceImpl crs = new CustomRepositoryServiceImpl();
            crs.addListInRepo(list);

            Specification specification = new SumSpecification(-2);
            logger.info(repository.query(specification));

        } catch (CustomException e) {
            e.printStackTrace();
        }
    }
}
