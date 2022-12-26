package current_scripts

import com.rdc.importer.scrapian.ScrapianContext
import com.rdc.importer.scrapian.model.StringSource
import com.rdc.importer.scrapian.util.ModuleLoader
import com.rdc.scrape.ScrapeAddress
import com.rdc.scrape.ScrapeEvent

context.setup([connectionTimeout: 50000, socketTimeout: 50000, retryCount: 2, multithread: true, userAgent: "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36"])
context.session.encoding = "UTF-8" //change it according to web page's encoding
context.session.escape = true

BOISecurityPDF script = new BOISecurityPDF(context)

script.initParsing()

class BOISecurityPDF {

    def final mainUrl = "https://www.bis.doc.gov/index.php/documents/regulations-docs/2713-supplement-no-6-to-part-744-unverified-list/file"
    def final entityType
    final ScrapianContext context
    final def moduleFactory = ModuleLoader.getFactory("d897871d8906be0173bebbbf155199ff441dd8d3")
    final def addressParser = moduleFactory.getGenericAddressParser(context)

    BOISecurityPDF(context) {
        this.context = context
        entityType = moduleFactory.getEntityTypeDetection(context)
    }

    def initParsing() {
        def pdfText = sanitizePdf(pdfToTextConverter(mainUrl))
//        println pdfText

        def matcher = pdfText =~ /(?sm)([A-Z\,?]{4,}\s+(?:[A-Z\’?]{4,})*\s+(?:[A-Z]{4,})*\s+(?:[A-Z]{2,})*)(.+?)(?=(?:[A-Z]{4,}\,?\s+\w+)|\Z)/

        def block

        while (matcher.find()) {
            block = sanitizeBlock(matcher.group(2))
            println "======================\n" +block

            def nameAliasAddressDateBlock = block =~ /(?ism)(.+?)((?:\d{1,2}\/\d{1,2}\/\d{2,4}\.)+|@)/


            def name, alias, address, date
            def nameAliasAddressBlock

            while (nameAliasAddressDateBlock.find()) {

                def aliasList
                def addressList
                def eventDateList
                nameAliasAddressBlock = nameAliasAddressDateBlock.group(1)
//                println nameAliasAddressDateBlock.group(2)

//                println "================================================================\n" + nameAliasAddressBlock

                def nameAliasAddress = nameAliasAddressBlock =~ /(?ism)(.+?)(?:\,)\s+(a\.k\.a\..+?(?:\,)(?:\s+a\.k\.a\..+?(?:\,))?(?:\s+a\.k\.a\..+?(?:\,))?)?(.+)/


                if (nameAliasAddress.find()) {
                    name = nameAliasAddress.group(1)
                    name = name.replaceAll(/(?s)\s+/, " ").trim()
                    alias = nameAliasAddress.group(2)


                    if (alias != null) {
                        alias = alias.replaceAll(/(?is)\s+/, " ").trim()
                        aliasList = alias.split(/(?is)a\.k\.a\./)
                    }

                    address = nameAliasAddress.group(3)
                    address = address.replaceAll(/(?s)\s+/, " ").trim()
                    addressList = address.split("; and")
//                    println " Name: " + name
//                    println " AliasList: " + aliasList
//
//                    addressList.each { ad -> println " Address: " + ad }

                   date = nameAliasAddressDateBlock.group(2)
                    if(date.replaceAll(/\s+/,"").trim() != "@"){
                        eventDateList = date.split(/\./)
//                        println "Date:" + eventDateList
//                    eventDateList.each { dateList -> println " Event Date: " + dateList}
                    }


//                    println "========================================================"
                }

                createEntity(name, aliasList, addressList,eventDateList)

            }


        }

    }


    def sanitizeBlock(def block) {
        block = block.replaceAll(/(?ism)(Co\.\,+\s+Ltd\.\,?)/, "Co. Ltd.,")
        block = block.replaceAll(/(?is)(Caspian.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Azerbaijan)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Rizma.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Canada)/, '$1 $3   $2')
        block = block.replaceAll(/(?is)(Services GP.+?)(\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}.)(.+)/, '$1 $2 $4 $3')

        block = sanitizeChina(block).toString()

        block = block.replaceAll(/(?is)(Bonitopto.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Jachymovska.+?Czech Republic)/, '$1 $3 $2')

        block = block.replaceAll(/(?is)(Simms\s+Marine.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)/, '$1 $3 $2$4')
        block = block.replaceAll(/(?is)(Intertranslog\s+OY.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Finland)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Sav-Inter\s+OY.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Finland)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Spars.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Georgia\, 0183)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Universal.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Germany)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Conduit.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Phoenix.+?India)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Alfa.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Nordic.+?Latvia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Al\s+Ghayth.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Lebanon)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Infomaya\s+Tech.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Malaysia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Premier\s+Kiosk.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Malaysia\s50450)/, '$1 $3 $2')

        block = sanitizeRussia(block).toString()

        block = block.replaceAll(/(?is)(Andleeb\s+Associates.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Pakistan)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(engro\s+Polymer.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Pakistan)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(T\.M\.A\.\s+International.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Iqbal Town\, Lahore\, Pakistan)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Dorado\s+Network.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Woodlands.+?Singapore)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Light\s+Range.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Figino\, Switzerland)/, '$1 $3 $2')

        block = sanitizeUnitedArabEmirates(block).toString()

        block = block.replaceAll(/(?is)(Caspian Oil Montaj)/, "Caspian Oil Montaj,")
        block = block.replaceAll(/(?is)(Rizma\, Inc.)/, "Rizma Inc.,")
        block = block.replaceAll(/(?is)(Services GP Tek)/, "Services GP Tek,")

        block = block.replaceAll(/(?is)(Bonitopto S\.R\.O\.)/, "Bonitopto S.R.O.,")
        block = block.replaceAll(/(?is)(Simms Marine Group OU)/, "Simms Marine Group OU,")
        block = block.replaceAll(/(?is)(Spars Ltd.)/, "Spars Ltd.,")
        block = block.replaceAll(/(?is)(Universal.+?GMBH)/, "Universal Logistics Systems GMBH,")
        block = block.replaceAll(/(?is)(Conduit.+?Pvt\.\, Ltd\.)/, "Conduit Technologies Pvt. Ltd.,")
        block = block.replaceAll(/(?is)(Alfa Photonics)/, "Alfa Photonics,")
        block = block.replaceAll(/(?is)(Al Ghayth Trade and Transport)/, "Al Ghayth Trade and Transport,")
        block = block.replaceAll(/(?is)(Infomaya Tech Sdn Bhd)/, "Infomaya Tech SDN BHD,")
//        block = block.replaceAll(/(?is)(Premier Kiosk Global Supply Co\.)/, "Premier Kiosk Global Supply Co.,")

        block = block.replaceAll(/(?is)(Andleeb Associates)/, "Andleeb Associates,")
        block = block.replaceAll(/(?is)(T\.M\.A\. International)/, "T.M.A. International,")

        block = block.replaceAll(/(?is)(Alliance EG Ltd\.)/, "Alliance EG Ltd.,")
        block = block.replaceAll(/(?is)(EFO Ltd\.)/, "EFO Ltd.,")
        block = block.replaceAll(/(?is)(Intercom Ltd\.)/, "Intercom Ltd.,")
        block = block.replaceAll(/(?is)(JSC Voentelecom)/, "JSC Voentelecom,")
        block = block.replaceAll(/(?is)(Nasosy Ampika)/, "Nasosy Ampika,")
        block = block.replaceAll(/(?is)(Nuclin llc)/, "Nuclin llc,")
        block = block.replaceAll(/(?is)(Radiofizika OAO)/, "Radiofizika OAO,")
        block = block.replaceAll(/(?is)(fsue.+?Branch)/, '$1,')
        block = block.replaceAll(/(?is)(SDB IRE RAS)/, "SDB IRE RAS,")
        block = block.replaceAll(/(?is)(Security 2 Business Academy)/, "Security 2 Business Academy,")
        block = block.replaceAll(/(?is)(Tavrida Microelectronics)/, "Tavrida Microelectronics,")
        block = block.replaceAll(/(?is)(VIP Technology Ltd\.)/, "VIP Technology Ltd.,")
        block = block.replaceAll(/(?is)(Dorado.+?Ltd\.)/, '$1,')
        block = block.replaceAll(/(?is)(Light Range AG)/, "Light Range AG,")
        block = block.replaceAll(/(?is)(Abu Trade llc)/, "Abu Trade LLC,")
        block = block.replaceAll(/(?is)(Alsaroud General Trading)/, "Alsaroud General Trading,")
        block = block.replaceAll(/(?is)(Alsima Middle East General Trading)/, "Alsima Middle East General Trading,")
        block = block.replaceAll(/(?is)(Blue Wing General Trading)/, "Blue Wing General Trading,")
        block = block.replaceAll(/(?is)(Doubair General Trading Co\. llc)/, "Doubair General Trading Co. LLC,")
        block = block.replaceAll(/(?is)(Empire of East General Trading)/, "Empire of East General Trading,")
        block = block.replaceAll(/(?is)(Establishment Standard Lab FZE)/, "Establishment Standard Lab FZE,")
        block = block.replaceAll(/(?is)(a\.k\.a\. Standard Lab FZE)/, "a.k.a. Standard Lab FZE,")
        block = block.replaceAll(/(?is)(Golden Business FZE)/, "Golden Business FZE,")
        block = block.replaceAll(/(?is)(Gulf.+?Company)/, '$1,')
        block = block.replaceAll(/(?is)(Kassem IT)/, "Kassem IT,")
        block = block.replaceAll(/(?is)(Masomi General Trading)/, "Masomi General Trading,")
        block = block.replaceAll(/(?is)(Middle East Oilfield Equipment)/, "Middle East Oilfield Equipment,")
        block = block.replaceAll(/(?is)(Renat.+?Trading)/, '$1,')
        block = block.replaceAll(/(?is)(Rich\s+Star.+?llc)/, '$1,')
        block = block.replaceAll(/(?is)(Recaz\s+Star.+?llc)/, '$1,')
        block = block.replaceAll(/(?is)(EBN AUF Trading)/, "EBN AUF Trading,")
        block = block.replaceAll(/(?is)(Roudah\s+Al.+?FZE)/, "Roudah Al Hayat General Trading FZE,")
        block = block.replaceAll(/(?is)(World Heavy Equipment)/, "World Heavy Equipment,")
        block = block.replaceAll(/(?is)(Trade Star FZC)/, "Trade Star FZC,")
        block = block.replaceAll(/(?is)(Tek Work General Trading)/, "Tek Work General Trading,")

        block = block.replaceAll(/(?is)(Nouvelle Option)/, "Nouvelle Option,")
        block = block.replaceAll(/(?is)(SZ Energy Technology Co\.)/, "SZ Energy Technology Co.,")
        block = block.replaceAll(/(?is)(SinoHTS)/, "SinoHTS,")
        block = block.replaceAll(/(?is)(Spars Trading Ltd\.)/, "Spars Trading Ltd.,")
        block = block.replaceAll(/(?is)(Global Kiosk)/, "Global Kiosk,")
        block = block.replaceAll(/(?is)(T.A. Industries Pvt. Ltd\.)/, "T.A. Industries Pvt. Ltd.,")
        block = block.replaceAll(/(?is)(Academy of Business Security)/, "Academy of Business Security,")
        block = block.replaceAll(/(?is)(Pacific Ocean Marine Services)/, "Pacific Ocean Marine Services,")
        block = block.replaceAll(/(?is)(World Equipment Trading L\.L\.C\.)/, "World Equipment Trading L.L.C.,")
        block = block.replaceAll(/(?is)(Marinatec)/, "Marinatec,")

        return block
    }

    def pdfToTextConverter(def pdfUrl) {
        def pdfFile = invokeBinary(pdfUrl)
        def pmap = [:] as Map
        pmap.put("1", "-layout")
        pmap.put("2", "-enc")
        pmap.put("3", "UTF-8")
        pmap.put("4", "-eol")
        pmap.put("5", "dos")
        //pmap.put("6", "-raw")
        def pdfText = context.transformPdfToText(pdfFile, pmap)
        return pdfText
    }

    def invokeBinary(url) {
        Map data = [url: url]
        return context.invokeBinary(data)
    }

    def sanitizePdf(def pdf) {
        def pdfText = pdf.toString()
        pdfText = pdfText.replaceAll(/(?ism)Unverified List+?/, "")
        pdfText = pdfText.replaceAll(/(?ism)SUPPLEMENT NO\. 6 TO PART 744 –/, "")
        pdfText = pdfText.replaceAll(/(?ism)Exports, reexports, and transfers \(in-country\) involving parties to the transaction who are listed\s*in this supplement are subject to the restrictions outlined in § 744.15 of the EAR./, "")
        pdfText = pdfText.replaceAll(/(?ism)COUNTRY/, "")
        pdfText = pdfText.replaceAll(/(?ism)LISTED PERSON AND ADDRESS/, "")
        pdfText = pdfText.replaceAll(/(?ism)FEDERAL\s*REGISTER\s*CITATION/, "")
        pdfText = pdfText.replaceAll(/(?ism)Export Administration Regulations+?/, "")
        pdfText = pdfText.replaceAll(/(?ism)Bureau of Industry and Security+?/, "")
        pdfText = pdfText.replaceAll(/(?ism)October 7\D+ 2022/, "")
        pdfText = pdfText.replaceAll(/(?ism)Supplement No\. \d+ to Part \d+—page \d+/, "")
        pdfText = pdfText.replaceAll(/(?i)JAFZA+?/, "jafza")
        pdfText = pdfText.replaceAll(/(?i)DAFZA+?/, "dafza")
        pdfText = pdfText.replaceAll(/(?i)RAKEZ+?/, "rakez")
        pdfText = pdfText.replaceAll(/AECC/, "aecc")

        pdfText = pdfText.replaceAll(/(?ism)(United arab)(\s\s+.+?)(Emirates)(\s\s+.+)/, '$1 $3 $2 $4')
        pdfText = pdfText.replaceAll(/(?ism)(CHINA\,)(\s+.+?)(PEOPLE\’S)(\s+.+)(REPUBLIC\sOF)(\s+.+)/, '$1 $3 $5 $2 $4 $6')
        pdfText = pdfText.replaceAll(/(?ism)(CZECH)(\s+.+?)(REPUBLIC)(\s+.+)/, '$1 $3 $2 $4')
        pdfText = pdfText.replaceAll(/(CHINA,\s+PEOPLE’S REPUBLIC OF\s+.+)(April)(\s+.+)(11, 2019.)/, '$1 $3 $2 $4')
        pdfText = pdfText.replaceAll(/\[INSERT/, "")
        pdfText = pdfText.replaceAll(/FEDERAL/, "")
        pdfText = pdfText.replaceAll(/REGISTER/, "")
        pdfText = pdfText.replaceAll(/PAGE/, "")
        pdfText = pdfText.replaceAll(/NUMBER AND/, "")
        pdfText = pdfText.replaceAll(/DATE OF/, "")
        pdfText = pdfText.replaceAll(/PUBLICATION\]/, "@")
        pdfText = pdfText.replaceAll(/CCIC/, "ccic")
        pdfText = pdfText.replaceAll(/HNHB/, "hnhb")
        pdfText = pdfText.replaceAll(/BAIJIA/, "Baijia")
        pdfText = pdfText.replaceAll(/ZDAS/, "zdas")
        pdfText = pdfText.replaceAll(/CRRC/, "crrc")
        pdfText = pdfText.replaceAll(/PKGS/, "pkgs")
        pdfText = pdfText.replaceAll(/ENGRO/, "engro")
        pdfText = pdfText.replaceAll(/FSUE/, "fsue")
        pdfText = pdfText.replaceAll(/ELOB/, "elob")
        pdfText = pdfText.replaceAll(/aka\s+/, "a.k.a.")
        pdfText = pdfText.replaceAll(/a\.k\.a\.\,/, "a.k.a.")
//        pdfText = pdfText.replaceAll(/87 FR/, "")
        pdfText = pdfText.replaceAll(/\d{2} FR (?:\d{2,}\,?)?/, "")
        pdfText = pdfText.replaceAll(/April 11, 2019\./, "04/11/2019.")
        pdfText = pdfText.replaceAll(/June 21, 2016\./, "06/21/2016.")
        pdfText = pdfText.replaceAll(/June 16, 2014\./, "06/16/2014.")
        pdfText = pdfText.replaceAll(/June 16, 2014\;/, "06/16/2014.")
        pdfText = pdfText.replaceAll(/January 29, 2015\./, "01/29/2015.")
        pdfText = pdfText.replaceAll(/January 29, 2015\;/, "01/29/2015.")
        pdfText = pdfText.replaceAll(/October 7, 2015\;/, "10/07/2015.")
        pdfText = pdfText.replaceAll(/October 7, 2015./, "10/07/2015.")
        pdfText = pdfText.replaceAll(/May 17, 2018\;/, "05/17/2018.")
        pdfText = pdfText.replaceAll(/(?:April 6, 2017\;|April 6, 2017\.)/, "04/06/2017.")

        return pdfText
    }


    def sanitizeChina(def block) {
        block = block.replaceAll(/(?is)(Able\s+Supply.+?)(\d{1,}\\/\d{1,}\\/\d{2,}\.)(.+?Sheung Wan\,\s+Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(aecc\sSouth.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3   $2')
        block = block.replaceAll(/(?is)(ARI\s.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3   $2')
        block = block.replaceAll(/(?is)(AW\s+Industrial.+?)(\d{1,}\\/\d{1,}\\/\d{2,}\.)(.+?Hung.+?Hong Kong)/, '$1 $3   $2')
        block = block.replaceAll(/(?is)(Beijing\sSWT.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3   $2')
        block = block.replaceAll(/(?is)(Beijing\sZhonghehangxun.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3   $2')
        block = block.replaceAll(/(?is)((?:Boson Technology|Boqur).+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Lockhart.+?Hong Kong)/, '$1 $3   $2')
        block = block.replaceAll(/(?is)(Brilliance.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Mong.+?Hong Kong)/, '$1 $3  $5 $2 : $4')
        block = block.replaceAll(/(?is)(Center.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\s201203)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Changchun\s+National.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\s130000)/, '$1 $3  $2')

        block = block.replaceAll(/(?is)(Changhe\s+Aircraft.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Chengde\s+Oscillator.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\s067506)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Central\s.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(China\sNational\sErzhong\s.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(China\s+National\s+Plant.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(CST\sSource.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Dandong\s+Center.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Daystar\s+Electric.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Wanchai\,\s+Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Dongguan\s+Durun.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Dongguan\sHuiqun\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?\d{6}\, China)/, '$1 $3  $2')

        block = block.replaceAll(/(?is)(E-Chips\sTechnology,\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)(.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)/, '$1 $3  $2 : $5')
        block = block.replaceAll(/(?is)(Emax\s+Technology.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Admiralty\, Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Fortune\sInternational\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Causeway Bay\, Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Fussion\sElectronics\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Globe\sCommunication\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Sheung Wan\, Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Guangdong\s+Guanghua.+?)(\d{1,}\/\d{1,}\/\d{2,})(.+?China\.)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Guangdong\sUniversity\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China 510006)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Guangxi\sIntai\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Guangzhou\sHymson\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Gucheng\s+Xian.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\s+253800)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Xiyuan\sIndustrial\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\s253800)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Harbin\sXinguang\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Heshan\sDeren\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3  $2')

        block = block.replaceAll(/(?is)(HK\s+Hengyu.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Flat\/Rm B11.+?Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Hong\s+Kong\s+Engy\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Hong\s+Kong\s+Haimao\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Hongbo\s+Industrial\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Kok Road.+?Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Huaduan\s+\(Anhui\).+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+China)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Hubei\s+Longchang\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Hubei\s+Sinophorus\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Hunan\sUniversity\,\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Jiangsu\shnhb\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Jiangxi\sHongdu\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3  $2')

        block = block.replaceAll(/(?is)(Jin\sYan\sTechnology\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Kowloon\, Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Jinan\sBodor\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Kenwoo\sInternational\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Kwai Chung, Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(KingV\sLtd\.\,\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Sheung\s+Wan\, Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Kunshan\sHeng\s+.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Lianqi\s+\(HK\).+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Ling\s+Ao.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?)(.+?Kwun Tong\, Hong Kong)/, '$1 $3 $5 $7 $9 $12 $2$4$6$8$10')
        block = block.replaceAll(/(?is)(Luoyang\s+Weimi.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\s471000)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Nanchang\s+University.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Nano\s+Tech.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)/, '$1 $3  $2')
        block = block.replaceAll(/(?is)(Narpel\s+Technology.+?)\s+(\d{1,}\/\d{1,}\/\d{2,4}\.)(.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Wan Chai\, Hong Kong)/, '$1 $3  $5 $7 $2 : $4 : $6')
        block = block.replaceAll(/(?is)(Powersun\s+Electronics.+?)(\d{1,}\/\d{1,}\/\d{2,4}\.)(.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?)(.+?Territories\, Hong Kong)/, '$1 $3 $6 $2 $4')
        block = block.replaceAll(/(?is)(Rising\s+Logistics.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong Island\, Hong Kong)/, '$1 $3 $2')

        block = block.replaceAll(/(?is)(Scitech\s+International.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+? Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Selective\s+Components.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+? Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Shaanxi\s+Hongyuan.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\s713801)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Shanghai\s+Fansheng.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Shanghai\s+Institute.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Shanghai\s+Micro\s+Electronics.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Shanxi\s+Hemu.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Shenzhen\s+Winthought.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3 $5 $2 : $4')
        block = block.replaceAll(/(?is)(Sino\s+Superconductor.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Southern\s+University.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Sun\s+Wing.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Sur-Link.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Suzhou\s+Chaowei.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3 $2')

        block = block.replaceAll(/(?is)(Swelatel\s+Technology.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Admiralty\,.+?Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(TRI\s+Microsystems.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Universe\s+Market.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Winthought\s+Company.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Wuxi\s+Beetech.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Wuxi\s+Biologics.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Yiwei.+?China\.)/, '$1 $3 $2')

        block = block.replaceAll(/(?is)(Xiang\s+Cheng.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Xinjiang\s+East.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Yashen\s+\(HK\)\s+Electronics\,.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Kowloon\, Hong\s+Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Yield\s+Best.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Yunnan\s+Fs.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Yunnan\s+Tianhe.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(ZDAS\s+\(HK\).+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Territories\, Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Zhengzhou\s+Baiwai.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(ZhongJie\s+Electronics.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Mongkok\,.+?Hong Kong)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Zhongshan\s+Thincloud.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\s528445)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Zhuzhou\s+CRRC.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?China\.)/, '$1 $3 $2')


        block = block.replaceAll(/(?is)(Center.+?Advanced Research)/, '$1,')
        block = block.replaceAll(/(?is)(Changchun National Extreme Precision Optics Co Ltd)/, "Changchun National Extreme Precision Optics Co Ltd,")
        block = block.replaceAll(/(?is)(ARI International\, Ltd\.)/, "ARI International Ltd., ")
        block = block.replaceAll(/(?is)(China\s+National.+?Co\.)/, '$1, ')
        block = block.replaceAll(/(?is)(Guangdong University of Technology)/, "Guangdong University of Technology, ")
        block = block.replaceAll(/(?is)(Guangdong Guanghua Sci-Tech Co\.)/, "Guangdong Guanghua Sci-Tech Co., ")
        block = block.replaceAll(/(?is)(Sino.+?Company)/, '$1,')
        block = block.replaceAll(/(?is)(Shenzhen Winthought Tech)/,"Shenzhen Winthought Tech,")
        block = block.replaceAll(/(?is)(Wuxi Beetech Inc\.)/, "Wuxi Beetech Inc,")
        block = block.replaceAll(/(?is)(Changhe Aircraft Industries Group)/, "Changhe Aircraft Industries Group,")
        block = block.replaceAll(/(?is)(Chengde.+?Technology\s+Co\.)/, '$1,')
        block = block.replaceAll(/(?is)(Dandong Center for Food Control)/, "Dandong Center for Food Control,")
        block = block.replaceAll(/(?is)(TRI Microsystems)/, "TRI Microsystems,")
        block = block.replaceAll(/(?is)(Kenwoo International Trade Company\,+)/, "Kenwoo International Trade Company,")
        block = block.replaceAll(/(?is)(Shaanxi Hongyuan Aviation Forging)/, "Shaanxi Hongyuan Aviation Forging,")
        block = block.replaceAll(/(?is)(Xinjiang East Hope New Energy Company Ltd)/, "Xinjiang East Hope New Energy Company Ltd,")
        block = block.replaceAll(/(?is)(Narpel Technology Co\.\, Limited\,)/, "Narpel Technology Co. Limited,")
        block = block.replaceAll(/(?is)(Nanchang University)/, "Nanchang University,")
        block = block.replaceAll(/(?is)(Luoyang Weimi Optics)/, "Luoyang Weimi Optics,")
        block = block.replaceAll(/(?is)(Jiangxi Hongdu Aviation Ind\. Group)/, "Jiangxi Hongdu Aviation Ind. Group,")
        block = block.replaceAll(/(?is)(Huaduan \(Anhui\) Machine Tool Manufacturer Co\.)/, "Huaduan (Anhui) Machine Tool Manufacturer Co.,")
        block = block.replaceAll(/(?is)(Gucheng.+?Alloy)/, '$1,')
        block = block.replaceAll(/(?is)(a\.k\.a\. Voyage\s+Technology \(HK\) Co\.\, Ltd\.\,)/, "a.k.a. Voyage Technology (HK) Co. Ltd.")
        block = block.replaceAll(/(?is)(Zhongshan Thincloud Optics Co\. Ltd\.)/, "Zhongshan Thincloud Optics Co. Ltd.,")

        return block
    }


    def sanitizeRussia(def block){
        block = block.replaceAll(/(?is)(Alliance\s+EG.+?)(\d{1,}\/\d{1,}\\/\d{2,}\.)(.+?Russia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(EFO\s+Ltd.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Novolitovskaya.+?Russia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Intercom.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Russia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(JSC\s+Voentelecom.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Russia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Nasosy\s+Ampika.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Russia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Nuclin.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Russia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Radiofizika.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Russia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(fsue\s+Rosmorport.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Russia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(SDB\s+IRE.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Russia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Security\s+2.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Novoslobodskaya.+?Russia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Tavrida.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Russia)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(VIP\s+Technology.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Russia)/, '$1 $3 $2')
        return block
    }



    def sanitizeUnitedArabEmirates(def block) {

        block = block.replaceAll(/(?is)(Abu\s+Trade.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Aero\s+King.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Ras Al Khaimah\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Alsaroud\s+General.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Al Jubail\, Sharjah\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Alsima\s+Middle.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Blue\s+Wing.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Doubair\s+General.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(EBN\s+AUF.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?42558.+?Emirates)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Elemental\s+Lab.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Baniyas Square\, Dubai\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Empire\s+of\s+East.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Road\s+Dubai\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Establishment\s+Standard.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?17049.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Golden\s+Business.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?\d{6}.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Gulf\s+Modern.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Kassem\s+IT.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Roundabout\s+8.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Lavender\s+General.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Maritime City\, Dubai\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Marinatec.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Deira\, Dubai\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Masomi\s+General.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Middle\s+East\s+Oilfield.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Salahuddin\s+Road\s+Dubai\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Pacific\s+Ocean\s+Star.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Office\s+\d{3}.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Recaz\s+Star.+?)\s+(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Renat\s+International.+?)\s+(\d{1,}\/\d{1,}\\/\d{2,}\.)(.+?Area\s+Ajman\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Rich\s+Star.+?)(\d{1,}\\/\d{1,}\\/\d{2,}\.)(.+?\d\s+Dubai\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Rising\s+Sun.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Dubai\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Roudah\s+Al\s+Hayat.+?)(\d{1,}\/\d{1,}\/\d{2,})(.+?Street\s+Dubai\, UAE)/, '$1 $3 $2.')
        block = block.replaceAll(/(?is)(Sea\s+Prince\s+Logistics.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Maritime City\, Dubai\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Tek\s+Work\s+General.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(Trade\s+Star.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?Sharjah\, UAE)/, '$1 $3 $2')
        block = block.replaceAll(/(?is)(World\s+Heavy.+?)(\d{1,}\/\d{1,}\/\d{2,}\.)(.+?UAE)/, '$1 $3 $2')

        return block
    }

    def sanitizeDate() {

    }

    def createEntity(name, aliasList, addressList, eventDateList) {
        def entity
        def type
        type = detectEntityType(name)
        entity = context.findEntity(["name": name, "type": type])
        entity = context.getSession().newEntity()
        entity.setName(name)
        entity.setType(type)

        if (aliasList) {
            aliasList.each { alias ->
                alias = alias.replaceAll(/(?s)\,/, "")
                alias = alias.replaceAll(/(?s)\s+/, " ").trim()
                alias = alias.replaceAll(/(?is)null/, "")
                if (alias) {
                    entity.addAlias(alias)
                }
            }
        }

        addressList.each { address ->
            def addressMap = addressParser.parseAddress([text: address, force_country: true])
            ScrapeAddress scrapeAddress = addressParser.buildAddress(addressMap)
            if (scrapeAddress) {
                if (scrapeAddress.address1) {
                    scrapeAddress.address1 = scrapeAddress.address1.replaceAll(/(?s)\s+/, " ").trim()
                }
                entity.addAddress(scrapeAddress)
            }

        }

        eventDateList.each { eDate ->
            ScrapeEvent event = new ScrapeEvent()
//            event.description = descr.replaceAll(/(?s)\s+/, " ").trim().replaceAll(/\s*:/, "")
            if (eDate) {
                def eventDate = context.parseDate(new StringSource(eDate), ["MM/dd/yy", "MM/d/yy", "M/d/yy", "M/dd/yy", "MMM d, yyyy", "MMM dd, yyyy"] as String[])
                event.setDate(eventDate)
                entity.addEvent(event)
            }
        }

    }

    def detectEntityType(def name) {
        def type = "O"
        return type
    }

}

