import Type.TypeSinistre;
import dao.SinistreDao;
import model.Sinistre;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {


        SinistreDao sdao =new SinistreDao();

        Sinistre s1 = new Sinistre(Date.valueOf("2025-09-22"), 13000.0, "1111111111",TypeSinistre.ACCIDENT_MAISON , 1);
        Sinistre s2 = new Sinistre(Date.valueOf("2025-09-22"), 13000.0, "22222222222222é",TypeSinistre.ACCIDENT_MAISON , 1);
        Sinistre s3 = new Sinistre(Date.valueOf("2025-09-22"), 13000.0, "3333333333",TypeSinistre.ACCIDENT_MAISON , 1);

        sdao.createSinistre(s1 );

        sdao.createSinistre(s2 );
        sdao.createSinistre(s3 );









    }
}