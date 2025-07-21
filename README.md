# 🐾 DIATICS – Hayvanat Bahçesi Simülasyonu

Bu proje, Java ile Nesne Yönelimli Programlama (OOP) prensipleri kullanılarak geliştirilmiş bir **hayvanat bahçesi simülasyonu**dur. Simülasyonda farklı türde hayvanlar; cinsiyet, tür ve davranışlara göre sınıflandırılarak yönetilir. Projede `Factory Pattern`, `enum`, `abstract class`, `generics`, `exception handling` gibi yapılar etkin şekilde kullanılmıştır.

---

## 📊 Değerlendirme Kriterlerine Göre Açıklamalar

### 📚 Dökümantasyon (%20)
- Proje Maven yapısı ile yapılandırılmıştır.
- Kodlar javadoc uyumlu yorum satırlarıyla açıklanmıştır.
- `README.md` dosyasında kurulum ve kullanım yönergeleri mevcuttur.

### 🧠 Algoritma Yaklaşımı (%30)
- Sınıflar arasında net bir OOP yapısı vardır: `Animal`, `HunterAnimal`, `HerbivoreAnimal`, `EcosystemManager`, `AnimalFactory`.
- `AnimalFactory` sınıfı ile tür, cinsiyet ve sınıf bazlı nesne üretimi yapılır.
- Sürü oluşturma algoritması `createHerd()` metodu ile esnekleştirilmiştir.
- Cinsiyet bazlı sayısal döngüler, davranış kontrolü ve sınıf tabanlı üretim mantığı içerir.

### 💻 Kodlama Pratikleri (%20)
- Tüm sınıflar tek sorumluluk prensibine göre yazılmıştır.
- `enum` ile tür ve cinsiyet kontrolü sağlanmıştır.
- `try-catch`, `generics`, `extends`, `abstract` gibi modern Java özellikleri kullanılmıştır.
- Kod tekrarından kaçınmak için soyut sınıflar ve kalıtım kullanılmıştır.

### 🛠️ Problem Çözüm Yaklaşımı (%30)
- Aynı türden çok sayıda hayvanı, tür bağımsız olarak üretmek gereksinimi vardı.
- Bu ihtiyaç `Factory` tasarım deseni ve `generics` ile çözülerek kod tekrarının önüne geçilmiştir.
- Sistemde tür, cinsiyet ve sınıf ayrımı hem algoritmik hem yapısal düzeyde doğru kurgulanmıştır.
- Hata yönetimi ile nesne oluşturma sırasında oluşabilecek problemler kontrol altına alınmıştır.

---

## 🚀 Projeyi Çalıştırmak

### Gereksinimler
- Java 17 veya üzeri
- Maven yüklü olmalı

### Komutlar

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.mycompany.diatics.DIATICS"
