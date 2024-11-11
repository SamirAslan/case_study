Specification Heading
=====================

Case 1
1) İstanbul Ankara arası gidiş dönüş uçuş aratılmalı (tarih ve rota parametrik yapılmalı)
2) Uçuşların listelendiği sayfada Gidiş kalkış varış saatleri filtresinden kalkış saati 10:00 ile 18:00 arası
seçilmeli
3) Uçuşların kalkış saatlerinin 10:00 ile 18:00 arasında olduğu kontrol edilmeli

     |ucusTipi   |nereden |nereye |  gidis   |  donus   |saat1|saat2|    havayolu     |
     |-----------|--------|-------|----------|----------|-----|-----|-----------------|
     |Gidiş-dönüş|  ISTA  |  ESB  |2025-02-05|2025-05-05|10:00|18:00|Türk Hava Yolları|

TC_001 Kalkış için saat aralığı kontrolu
---------------------------
tags: web
* <ucusTipi> seçiliyor.
* Gidis icin <nereden> havalimani seciliyor.
* Donus icin <nereye> havalimani seciliyor.
* <gidis> ve <donus> tarihi seciliyor.
* Ucuz Bilet Bul butonuna tiklanir.
* Gidis-Donus sonuclarinin <nereden>,<nereye>,<gidis>,<donus> bilgilere gore geldigi dogrulanir.
* Ucus listesinin geldigi dogrulanir.
* "Gidiş kalkış / varış saatleri" filtiresine tiklaniyor.
* Kalkis saati <saat1> ile <saat2> seciliyor.
* Ucusların kalkis saatleri <saat1> ile <saat2> arasinda oldugu dogrulanir.



Case 2
1) İstanbul Ankara arası gidiş dönüş uçuş aratılmalı (tarih ve rota parametrik yapılmalı)
2) Uçuşların listelendiği sayfada Gidiş kalkış varış saatleri filtresinden kalkış saati 10:00 ile 18:00 arası
seçilmeli
3) Listelenen uçuşlarda Türk hava yolları uçuşları fiyatlarının sıralamasının artan şekilde geldiği
kontrol edilmeli

TC_002 Havayolu için artan fiyat kontrolu
---------------------------
tags: web
//* <url> sayfasina gidilir.
* <ucusTipi> seçiliyor.
* Gidis icin <nereden> havalimani seciliyor.
* Donus icin <nereye> havalimani seciliyor.
* <gidis> ve <donus> tarihi seciliyor.
* Ucuz Bilet Bul butonuna tiklanir.
* Gidis-Donus sonuclarinin <nereden>,<nereye>,<gidis>,<donus> bilgilere gore geldigi dogrulanir.
* Ucus listesinin geldigi dogrulanir.
* "Gidiş kalkış / varış saatleri" filtiresine tiklaniyor.
* Kalkis saati <saat1> ile <saat2> seciliyor.
* <havayolu> icin fiyatlarin artan sekilde geldigi dogrulanir.



Case 3
1) Enuygun web sitesinde sıkıntı yaşanırsa impacti en yüksek olabileceğini düşündüğünüz noktayı
belirleyip bir otomasyon case'i hazırlanmalı

Cevap: Önem derecesi en yüksek nokta ödeme aşaması olduğunu düşünüyorum.
        Bu aşamadayken alınabilecek bir hata rezervasyonun tamamlanmamasına sebep olacaktır.
        Bu da potansiyel satışın, aktif satışa dönüşmemesine sebeptir.


TC_003 İmpacti en yüksek durum: Ödeme ekran kontrolu
-----------------------------
tags: web
//* <url> sayfasina gidilir.
* Gidis icin <nereden> havalimani seciliyor.
* Donus icin <nereye> havalimani seciliyor.
* Gidis icin <gidis> tarihi seciliyor.
* Ucuz Bilet Bul butonuna tiklanir.
* Tek Yon sonuclarinin <nereden>,<nereye>,<gidis> bilgilere gore geldigi dogrulanir.
* Ucus listesinin geldigi dogrulanir.
* İlk ucusun "Süper Eko" paketi seçili oldugu doğrulanır.
* Rezervasyon sayfasina gidilir ve "Bilgilerini Gir" sayfasinin geldiği doğrulanir.
* İletisim bilgileri "test@gmail.com" ve "5111111111" girilir.
* Yolcu ismi "Yılmaz", soyad "Morgül" girilir.
* Dogum tarihi "05","02","1995" girilir.
* TC Vatandasi Degil secilir.
* Cinsiyet secilir.
* Odemeye ilerle butonuna tiklanir ve Odeme ekraninin geldiği dogrulanir.