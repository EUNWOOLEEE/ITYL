package org.scoula.travel.dataimport;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.util.List;
import org.scoula.database.JDBCUtil;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.TravelVO;

public class ImportTravelData {
    public static void main(String[] args) {
        try {
            List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
                    .withType(TravelVO.class)
                    .build()
                    .parse();

            TravelDaoImpl travelDao = new TravelDaoImpl();

            travels.forEach(travel -> travelDao.insert(travel));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close();
        }
    }
}
