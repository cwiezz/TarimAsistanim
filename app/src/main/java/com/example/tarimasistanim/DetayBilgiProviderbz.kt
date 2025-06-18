package com.example.tarimasistanim.data

import android.R.attr.text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class BahceZararlisiDetay(
    val title: String,
    val descriptionbz: String,
    val suggestion: String,

)

object DetayBilgiProviderbz {
    fun getBilgibz(idbz: Int): BahceZararlisiDetay {
        return when (idbz) {
            8 -> BahceZararlisiDetay(
                title = "Domates Güvesi",
                descriptionbz = "Domates güvesi, domatesin yaprak, sap ve meyvesine zarar veren bir zararlıdır. Yaprakların arasında tüneller açarak beslenir, meyvelerde çürümeye yol açar. Küçük boyutuna rağmen tarlalarda çok hızlı yayılır ve verim kaybına neden olur.",
                suggestion = "Bitki Kontrolü ve Elle Ayıklama: Sabah saatlerinde bitki yapraklarını dikkatle inceleyin. Yaprak altlarında veya tomurcuklarda görülen minik beyaz yumurtaları veya larvaları fark ederseniz elinizle toplayarak uzaklaştırın. Zarar görmüş yaprakları budayıp bitkiden uzaklaştırın.\n" +
                        "\n" +
                        "Feromon Tuzakları Kurun: Tarlaya veya seraya domates güvesine özgü feromon içeren yapışkan tuzaklar yerleştirin. Erkek güveleri cezbederek dişiyle eşleşmelerini engeller. Bu da popülasyon artışını büyük oranda durdurur.\n" +
                        "\n" +
                        "Biyolojik Mücadele: Faydalı böceklerden Trichogramma arısı, güve yumurtalarıyla beslenir. Bu arılar belirli dönemlerde salındığında güve nüfusunu doğal yolla kontrol altına alır.\n" +
                        "\n" +
                        "Sistemik İlaç Uygulaması: Eğer doğal yöntemler yetersiz kalıyorsa, domates güvesine karşı özel olarak üretilmiş sistemik etkili böcek ilaçlarını kullanabilirsiniz. Ancak meyveye hasat süresi dikkate alınarak etiket bilgilerine mutlaka uyulmalıdır.",
            )

            9 -> BahceZararlisiDetay(
                title = "Kırmızı Örümcek",
                descriptionbz = "Kırmızı örümcek akarları, çıplak gözle zor fark edilebilecek kadar küçük, kırmızımsı renkli zararlılardır. Bitkilerin yapraklarının alt yüzeyine yerleşirler ve özsuyunu emerler. Yapraklarda sarı benekler, kuruma ve ince ağ oluşumu gibi belirtiler bırakırlar. Özellikle sıcak ve kuru hava koşullarında hızla çoğalırlar.",
                suggestion = "Rutin su spreyi uygulaması: Bu akarlar nemli ortamlardan hoşlanmazlar. Bu nedenle bitkilerinize özellikle yaprak altlarına haftada birkaç kez su püskürterek popülasyonlarını azaltabilirsiniz.\n" +
                        "\n" +
                        "Bitkiyi Duşlama Yöntemi: Eğer bitkiniz saksıda ise, banyoda duş başlığıyla yapraklarını iyice yıkayın. Bu yöntem akarların büyük kısmını fiziksel olarak uzaklaştırır.\n" +
                        "\n" +
                        "Kükürtlü Sprey Kullanımı: Bahçe marketlerinden veya zirai ilaççılardan temin edilebilecek \"kükürt içeren doğal spreyleri\" kullanarak akarlarla etkili bir şekilde mücadele edebilirsiniz. Etiket üzerindeki oranlara dikkat ederek uygulama yapınız.\n" +
                        "\n" +
                        "Bitkiler Arası Mesafe: Bitkilerinizi birbirine çok yakın yerleştirmemeye çalışın. Akarlar bir bitkiden diğerine kolayca geçebilir. Aralarındaki hava sirkülasyonu da hastalığın yayılmasını yavaşlatır.\n" +
                        "\n" +
                        "Sarı Yapışkan Tuzaklar: Akarlar doğrudan bu tuzaklara gelmese de, varsa birlikte yaşayan trips ya da beyaz sinek gibi zararlıları da kontrol etmek açısından yararlıdır.",
            )

            10 -> BahceZararlisiDetay(
                title = "Lahana Kelebeği",
                descriptionbz = "Lahana kelebekleri özellikle lahana, karnabahar ve brokoli gibi brassica ailesi bitkilere zarar verir. Yumurtalarını yaprakların altına bırakırlar. Yumurtadan çıkan tırtıllar hızla büyür ve yaprakları kemirerek iskelet haline getirir.",
                suggestion = "Elle tırtıl toplama: Sabah veya akşam saatlerinde bitkileri kontrol edin. Özellikle yaprak altlarında bulunan yumurtaları ve tırtılları elinizle toplayarak bir kaba alın. Bu yöntem küçük alanlarda oldukça etkilidir.\n" +
                        "\n" +
                        "Sirke-Su Spreyi: 1 litre suya 1 su bardağı elma sirkesi ve birkaç damla sıvı sabun ekleyin. Bu karışımı doğrudan yaprakların üstüne ve altına püskürtün. Tırtılların yapraklarda tutunmasını zorlaştırır ve çoğunu uzaklaştırır.\n" +
                        "\n" +
                        "Bacillus Thuringiensis (Bt) Kullanımı: Tarım marketlerinden temin edilebilen bu biyolojik ilaç, tırtıllar tarafından yutulduğunda onları öldürür ama faydalı böceklere zarar vermez. Erken sabah saatlerinde uygulanmalı ve yağmurdan önce bitkinin üzerinde kuruması beklenmelidir.\n" +
                        "\n" +
                        "Kuşlara Fırsat Tanıyın: Bahçeye kuşların uğramasını sağlamak için su kapları koyabilir ya da küçük yemlikler asabilirsiniz. Serçeler ve diğer kuş türleri tırtılları büyük iştahla tüketir.\n" +
                        "\n",

                )

            11 -> BahceZararlisiDetay(
                title = "Meyve Sineği",
                descriptionbz = "Meyve sineği, özellikle kayısı, şeftali, narenciye ve incir gibi meyvelerde büyük zarara yol açan, Akdeniz kökenli bir zararlıdır. Dişi sinek meyve kabuğuna yumurta bırakır. Yumurtadan çıkan larvalar meyvenin içinde beslenerek iç yapısını bozar, çürütür ve düşmesine neden olur. Pazarlanabilirliği yok olan meyveler hem ürün hem kalite kaybına neden olur.",
                suggestion = "Ev Yapımı Sirke Tuzağı: Şeffaf bir pet şişeyi alın ve gövdesine birkaç delik açın. İçine elma sirkesi, bir miktar su ve birkaç damla bulaşık deterjanı ekleyin. Sirke meyve sineklerini çekerken, deterjan sineklerin sıvıda batmasını sağlar. Bu tuzağı meyve ağaçlarının altına veya dallarına asarak kullanın. Haftada bir karışımı yenileyin.\n" +
                        "\n" +
                        "Bahçeye Erken Hasat Uygulayın: Meyveleri tam olgunlaşmadan önce toplamak, meyve sineğinin yumurtlayacak uygun ortam bulmasını engeller.\n" +
                        "\n" +
                        "Feromon Tuzakları: Tarım marketlerinde satılan özel feromon kapsülleri, erkek meyve sineklerini cezbeder. Bu kapsülleri yapışkan kartlarla birlikte kullanarak sinekleri yakalayabilirsiniz. Bu sayede popülasyonun kontrolü sağlanır.\n" +
                        "\n" +
                        "Steril Erkek Sinek Salımı (İleriye Dönük): Bu biyoteknik yöntem, yerel zirai kurumlar tarafından uygulandığında meyve sineği popülasyonunun üremesi ciddi oranda engellenir.",
            )

            12 -> BahceZararlisiDetay(
                title = "Trips",
                descriptionbz = "Tripsler, çok küçük ve dar yapılı böceklerdir; bitkilerin özsuyunu emer ve yaprak, çiçek ve meyvelerde renk değişimi, gümüşleşme ve beneklenme gibi zararlara yol açar. Aynı zamanda birçok virüs hastalığını da bitkiler arasında yayabilirler. Özellikle domates, biber, çilek ve süs bitkilerinde görülürler.",
                suggestion = "Mavi Yapışkan Tuzaklar Kurun: Tripsler mavi renge yönelir. Tarım marketlerinden veya online satışlardan alabileceğiniz mavi yapışkan kartları, bitkilerin hizasında asarak popülasyonlarını izleyebilir ve azaltabilirsiniz. Kartları her 10 metrekareye 1 adet olacak şekilde yerleştirin ve haftalık olarak değiştirin.\n" +
                        "\n" +
                        "Sabunlu Su Püskürtme: 1 litre suya 1 tatlı kaşığı sıvı sabun karıştırarak bitkilerin özellikle yaprak alt yüzeylerine püskürtün. Bu karışım tripslerin yapışkan yapısını bozarak nefes almalarını zorlaştırır. Her 3–4 günde bir uygulama tekrarlanabilir.\n" +
                        "\n" +
                        "Neem Yağı Spreyi: Neem yağı, trips gibi yumuşak vücutlu zararlılara karşı oldukça etkilidir. 1 litre suya 5 ml neem yağı ve birkaç damla sıvı sabun ekleyerek iyice çalkalayın. Bitkinin her yerine sabah serinliğinde püskürtün. Gerekirse haftada 1–2 tekrar edin.\n" +
                        "\n" +
                        "Doğal Avcı Böcek Salımı: Orius türü avcı böcekler tripslerle beslenir. Tarım destek merkezlerinden temin edilebilecek bu faydalı böcekler, seralarda veya küçük bahçelerde trips kontrolünü doğal yollarla sağlar.\n" +
                        "\n" +
                        "Bitkiler Arası Mesafe ve Havalandırma: Tripsler kalabalık ve havasız alanlarda daha kolay yayılır. Bitkiler arasında yeterli mesafe bırakmak, hastalık bulaşmasını da önler.",
            )

            13 -> BahceZararlisiDetay(
                title = "Tel Kurdu",
                descriptionbz = "Tel kurdu, toprağın altında yaşayan, genellikle mısır, patates, havuç ve buğday gibi kök ürünlerine zarar veren sarımsı kahverengi, sert kabuklu larvalardır. Toprakta gizlenerek kökleri kemirirler ve bu durum bitkinin gelişimini durdurur, bazen tamamen ölmesine sebep olur. Yumrulu sebzelerde delikler açarak ürünü çürütür ve pazar değerini yok eder.",
                suggestion = "Patates Tuzağı Yöntemi: Bir patatesi ikiye kesin ve içine kürdan saplayarak toprağa yarı gömülü şekilde yerleştirin. Tel kurtları patatesin nişastasına çekilecek ve içine girecektir. 2-3 gün sonra bu tuzakları kontrol edin ve içindeki zararlılarla birlikte toprağın dışına çıkarıp imha edin. Bu işlemi birkaç hafta boyunca tekrar edin.\n" +
                        "\n" +
                        "Derin Sürüm ve Havalandırma: Toprağın sık sık sürülmesi, tel kurtlarının üst katmanlara çıkmasına neden olur. Bu da kuşlar ve diğer doğal avcılar tarafından daha kolay yenmesini sağlar. Özellikle kış sonunda ve yaz başında derin sürüm yapılması etkilidir.\n" +
                        "\n" +
                        "Organik Gübre Kullanımı: Yanmış çiftlik gübresi veya kompost gibi organik materyaller, faydalı mikroorganizmaların gelişmesini teşvik eder ve tel kurdu popülasyonunu dengede tutar.\n" +
                        "\n" +
                        "Tarlada Kuşları Destekleyin: Tel kurdunun doğal düşmanları arasında kuşlar, karıncalar ve bazı yer solucanları yer alır. Bahçeye kuşlar için su ve yem alanları koymak, bu faydalı hayvanların kalmasını sağlar.\n" +
                        "\n" +
                        "Toprak İlaçlaması (Zorunluysa): Granül formdaki sistemik toprak ilaçları, ekimden önce veya ekim sırasında toprağa karıştırılarak uygulanabilir. Bu uygulama sadece ciddi yoğunluklarda ve diğer yöntemler başarısız olursa tercih edilmelidir.",
            )

            14 -> BahceZararlisiDetay(
                title = "Yaprak Biti",
                descriptionbz = "Yaprak bitleri, bitkilerin özsuyunu emerek onları zayıflatan, çok hızlı çoğalan küçük böceklerdir. Genellikle yeşil, siyah, sarı veya gri renkte olabilirler. Genç sürgünlerde ve yaprakların alt yüzeylerinde koloni halinde yaşarlar. Bitkide yaprakların kıvrılması, sararması, büyümenin durması gibi belirtiler görülür. Ayrıca salgıladıkları tatlımsı sıvı (ballı madde) karıncaları çeker ve bu madde üzerinde kurumaya sebep olan mantarlar gelişebilir.",
                suggestion = "Bitkiye Su Püskürtme: İlk olarak bitkinin yaprak altlarını hafifçe akan bir suyla yıkayın. Bu, yaprak bitlerinin çoğunu uzaklaştırır. Özellikle sabah saatlerinde yapmak, bitkinin gece kurumadan girmesini sağlar.\n" +
                        "\n" +
                        "Ev Yapımı Sabunlu Su Spreyi: Bir sprey şişesine 1 litre su, birkaç damla sıvı bulaşık deterjanı ve 1 yemek kaşığı bitkisel yağ (örneğin zeytinyağı) ekleyin. Karıştırdıktan sonra bitkinin yapraklarına ve saplarına püskürtün. Haftada 2-3 kez uygulanabilir.\n" +
                        "\n" +
                        "Neem Yağı Kullanımı: Neem yağı doğal ve etkili bir böcek kovucudur. 1 litre suya yaklaşık 5 ml neem yağı ve birkaç damla sıvı sabun ekleyin. Karıştırıp aynı şekilde püskürtün. Zararlılar üzerinde toksik etki yaratır ama bitkilere zarar vermez.\n" +
                        "\n" +
                        "Uğur Böceklerini Çekin: Yaprak bitlerinin doğal avcısı olan uğur böceklerini bahçenize çekmek için nane, dereotu veya rezene gibi bitkiler ekebilirsiniz. Uğur böcekleri kısa sürede yaprak bitlerini tüketir.",
            )

            else -> BahceZararlisiDetay(
                title = "BİLİNMEYEN",
                descriptionbz = "Açıklama bulunamadı.",
                suggestion = "Ekim bilgisi bulunamadı.",
            )
        }
    }
}
