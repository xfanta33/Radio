package fr.xfanta.radio.utils;

import java.util.HashMap;

public class RadioList {

    private static HashMap<String, String> RadioList;
    private static HashMap<String, String> RadioListFromInternet;

    public static void RadioListSet(){
        RadioList = new HashMap<String, String>();
        RadioList.put("", "v7E2u8Ua");
        RadioList.put("Funradio", "http://streaming.radio.funradio.fr/fun-1-48-192");
        RadioList.put("NRJ", "http://cdn.nrjaudio.fm/audio1/fr/30001/mp3_128.mp3?origine=fluxradios");
        RadioList.put("Skyrock", "http://icecast.skyrock.net/s/natio_mp3_128k");
        RadioList.put("Moov", "http://direct.mouv.fr/live/mouv-midfi.mp3");
        RadioList.put("Virgin", "http://ais-live.cloud-services.paris:8000/virgin.mp3");
        RadioList.put("WitFM", "http://start-witfm.ice.infomaniak.ch/start-witfm-high.mp3");
        RadioList.put("CherieFM", "http://cdn.nrjaudio.fm/audio1/fr/30201/mp3_128.mp3?origine=fluxradios");
        RadioList.put("Classique", "http://radioclassique.ice.infomaniak.ch/radioclassique-high.mp3");
        RadioList.put("Europe1", "http://e1-live-mp3-128.scdn.arkena.com/europe1.mp3");
        RadioList.put("Fip", "http://direct.fipradio.fr/live/fip-midfi.mp3");
        RadioList.put("FranceCulture", "http://direct.franceculture.fr/live/franceculture-midfi.mp3");
        RadioList.put("FranceInfo", "http://direct.franceinfo.fr/live/franceinfo-midfi.mp3");
        RadioList.put("FranceInter", "http://direct.franceinter.fr/live/franceinter-midfi.mp3");
        RadioList.put("FranceMusique", "http://direct.francemusique.fr/live/francemusique-midfi.mp3");
        RadioList.put("Nostalgie", "http://cdn.nrjaudio.fm/audio1/fr/30601/mp3_128.mp3?origine=fluxradios");
        RadioList.put("Nova", "http://novazz.ice.infomaniak.ch/novazz-128.mp3");
        RadioList.put("RFM", "http://rfm-live-mp3-128.scdn.arkena.com/rfm.mp3");
        RadioList.put("RTL", "http://streaming.radio.rtl.fr/rtl-1-48-192");
        RadioList.put("RTL2", "http://streaming.radio.rtl2.fr/rtl2-1-48-192");
        RadioList.put("RireChansons", "http://cdn.nrjaudio.fm/audio1/fr/30401/mp3_128.mp3?origine=fluxradios");
        RadioList.put("Autre", "v7E2u8Ub");
    }

    public static HashMap<String, String> getRadioList(){
        return RadioList;
    }

}
