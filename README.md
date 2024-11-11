# ENUYGUN CASE STUDY AUTOMATION

Gauge Framework kullanarak Test Otomasyon projesi oluşturulmuştur.

## Başlangıç

Bu bölüm, projeyi **Windows** için nasıl çalıştıracağınız veya kuracağınız hakkında temel bilgileri içerir. Başka bir deyişle, projeyi kullanmaya başlamanızı sağlayacak talimatlar.

### Gereksinimler
Projenizi çalıştırmadan önce yüklü olması gereken yazılımlar veya kütüphaneler:
- Java 21.0.5
- Gauge 1.6.10
- Maven 3.9.9
- Selenium 4.25.0

### Kurulum

1. Öncelikle `Java`, `Maven` ve `Gauge` indiriliyor:
  
> https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe (sha256)

> https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.zip

> https://docs.gauge.org/getting_started/installing-gauge.html?os=windows&language=java&ide=vscode


2. Bilgisayarın **ortam değişkenlerine** gidilir ve ``Java``,``Maven``,``Gauge``'nin değişkenleri tanımlanır.

>![javaMaven.png](src%2Ftest%2Fresources%2Freadme%2FjavaMaven.png)

> ![path.png](src%2Ftest%2Fresources%2Freadme%2Fpath.png)



3. Terminalden versiyon kontrolleri yapılır. 

> java -version

> mvn -v

> gauge -v


4. Gauge Pluginleri olmayacaktır. ``No plugins found`` yazacaktır. Pluginleri eklememiz gerekiyor.

> gauge install java

> gauge install html-report

> gauge install xml-report

> gauge install json-report

> gauge install spectacle

> gauge install flash

Bu pluginleri yükledikten sonra yeniden versiyon kontrol yaparsanız eğer aşağıdakı görseli göreceksiniz.

>![gauge.png](src%2Ftest%2Fresources%2Freadme%2Fgauge.png)



### Projeyi çalıştırma önce

>Intellij IDEA de ``File > Open > enuygunCaseStudyAutomation`` şeklinde projemizi açıyoruz.

>Intellij IDEA de ``File > Settings > Plugins > Marketplace`` adımlarını takip ederek Marketplaceden ``Gauge``'yi install ediyoruz.

>Intellij IDEA'nin sağ tarafında Maven iconuna tıklanır ve oradakı ``Lifecycle``'dan önce ``clean`` sonra ``compile`` ve son olarak da ``install`` yapılır.

>![lifecycle.png](src%2Ftest%2Fresources%2Freadme%2Flifecycle.png)

> Sonucların **BUILD SUCCESS** olduğu görülür.

> Projedeki **chromedriver** ile bilgisayardakı **chrome** sürümleri aynı olduğu kontrol edilmelidir. 

> ![img.png](src%2Ftest%2Fresources%2Freadme%2Fimg.png)
> 
> chromedriver 130.0.6723.92
> 
> https://googlechromelabs.github.io/chrome-for-testing/ bu linkten indirebilrsiniz.


### Projeyi çalıştırmak

> Projeyi çalıştırmak için ``specs > Scenarios`` klasörü altındakı ``CaseStudy.spec`` dosyasına gidilir.
>
> ![spec.png](src%2Ftest%2Fresources%2Freadme%2Fspec.png)

> Bu spec dosyasının içinde senaryoları tek tek veya bir arada çalıştırabilirsiniz.
>
> ![run.png](src%2Ftest%2Fresources%2Freadme%2Frun.png)


### Çalıştırdıktan sonra

>``reports > html-report > specs > Scenarios`` klasörünün altındakı ``CaseStudy.html`` dosyasını bir browser da açarsanız eğer koşum raporuna ulaşabilirsiniz.

>![html.png](src%2Ftest%2Fresources%2Freadme%2Fhtml.png)

>![rapor.png](src%2Ftest%2Fresources%2Freadme%2Frapor.png)



# Teşekkürler