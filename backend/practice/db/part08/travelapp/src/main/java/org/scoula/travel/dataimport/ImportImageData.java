package org.scoula.travel.dataimport;

import java.io.File;
import org.scoula.database.JDBCUtil;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.TravelImageVO;

public class ImportImageData {
    public static void main(String[] args) {
        try {
            File dir = new File("travel-image");
            for (File file : dir.listFiles()) {
                String fileName = file.getName();
                long travelNo = Long.parseLong(fileName.split("-")[0]);

                TravelImageVO image = TravelImageVO.builder()
                        .filename(fileName)
                        .travelNo(travelNo)
                        .build();

                TravelDaoImpl travelDao = new TravelDaoImpl();
                travelDao.insertImage(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close();
        }
    }
}
