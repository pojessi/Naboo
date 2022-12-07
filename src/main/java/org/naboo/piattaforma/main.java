package org.naboo.piattaforma;

import java.io.IOException;

public class main {


    public static void main(String[] args) throws IOException {
        amministratore amm=new amministratore();

        //amm.aggiungiFonte(); Ora la gui passa già le informazioni!

        amm.startFonte();
        amm.leggiFilePresenti();
        amm.importareFileNotizie();
        amm.autore();
        amm.categoria();
        //non va   amm.rimuoviFonte(); Ora la gui passa già le informazioni!
        //amm.aggiungiNotizia(); Ora la gui passa già le informazioni!
        //amm.aggiungiFonte(); Ora la gui passa già le informazioni!
        amm.stampaFonti();
        //amm.aggiungiNotizia();
        amm.startNotizia();
        //amm.startNotizia();
        amm.startFonte();
       // amm.startFonte();
    }
}
