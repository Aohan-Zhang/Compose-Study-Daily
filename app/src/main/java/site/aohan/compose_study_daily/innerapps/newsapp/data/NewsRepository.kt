@file:Suppress("unused")

package site.aohan.compose_study_daily.innerapps.newsapp.data

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.delay
import site.aohan.compose_study_daily.config.client
import site.aohan.compose_study_daily.config.json
import site.aohan.compose_study_daily.innerapps.newsapp.model.NewsModel

object NewsRepository {

    suspend fun getNewsFromBjb(): List<NewsModel> {
        val response = client.get("http://bjb.yunwj.top/php/60miao/qq.php")
        return response.body<NewsFromBjbDTO>().toModels()
    }

    suspend fun getNewsFromBjbLocal(): List<NewsModel> {
        delay(1000)
        return json.decodeFromString<NewsFromBjbDTO>(
            """
            {
              "lj": "备用链接1",
              "zt": 0,
              "tp": "http://bjb.yunwj.top/php/60miao/2.jpg",
              "lx": "有什么问题可以联系QQ群：963076428微信号：Q3257117851",
              "wb": [
                [
                  "1、据报道，截至1月1日19时8分，2024年元旦档（2023年12月30日—2024年1月1日）新片总票房突破15亿元。",
                  "https://www.baidu.com/s?wd=%E5%85%83%E6%97%A6%E6%A1%A3%E7%A5%A8%E6%88%BF%E8%B6%8515%E4%BA%BF%E5%85%83%E7%A0%B4%E5%BD%B1%E5%8F%B2%E7%BA%AA%E5%BD%95&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "2、12月18日，甘肃临夏州积石山发生6.2级地震。地震发生后，各方迅速组织救援，转移安置受灾群众，确保受灾群众安全温暖过冬。",
                  "https://www.baidu.com/s?wd=%E5%AF%92%E5%86%AC%E4%B8%AD%E7%9A%84%E6%B8%A9%E6%9A%96&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "3、12月31日，湖南长沙一女子在地摊遇麻辣烫刺客被老板收取106元一份，女子不满夹菜与老板当面核对。",
                  "https://www.baidu.com/s?wd=%E6%B8%B8%E5%AE%A2%E5%9C%A8%E5%9C%B0%E6%91%8A%E9%81%87%E5%A4%A9%E4%BB%B7%E9%BA%BB%E8%BE%A3%E7%83%AB106%E5%85%83%E4%B8%80%E4%BB%BD&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "4、南方小金豆表白哈尔滨",
                  "https://www.baidu.com/s?wd=%E5%8D%97%E6%96%B9%E5%B0%8F%E9%87%91%E8%B1%86%E8%A1%A8%E7%99%BD%E5%93%88%E5%B0%94%E6%BB%A8&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "5、此前，网传泉州一小区的物业公司向业主催缴高达800万的水费，引发关注。经核实系造谣，造谣者已被公安机关依法作出行政处罚。",
                  "https://www.baidu.com/s?wd=%E6%B3%89%E5%B7%9E%E4%B8%80%E5%B0%8F%E5%8C%BA%E5%82%AC%E7%BC%B4800%E4%B8%87%E6%B0%B4%E8%B4%B9%EF%BC%9F&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "6、据报道，自2024年1月1日起，备受老年人欢迎的电动三、四轮车，将在北京街头消失。此前，已有多地出台政策拟禁止老头乐。",
                  "https://www.baidu.com/s?wd=%E5%85%A8%E5%9B%BD%E5%A4%9A%E4%B8%AA%E5%9F%8E%E5%B8%82%E7%A6%81%E6%AD%A2%E8%80%81%E5%A4%B4%E4%B9%90&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "7、在黑龙江，一名游客隔着铁网对着东北虎的大脸疯狂撒雪，老虎一脸无奈又安静。东北虎：这位南方小土豆，请叫我咪咪。",
                  "https://www.baidu.com/s?wd=%E4%B8%9C%E5%8C%97%E8%99%8E%E9%81%87%E8%A7%81%E5%8D%97%E6%96%B9%E5%B0%8F%E5%9C%9F%E8%B1%86%E7%A7%92%E5%8F%98%E5%92%AA%E5%92%AA&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "8、1月1日，东京电力公司称，已确认地震导致新潟县柏崎刈羽核电站2号、3号、6号和7号机组反应堆建筑物顶层燃料池水溢出。",
                  "https://www.baidu.com/s?wd=%E6%97%A5%E6%9C%AC%E4%B8%80%E6%A0%B8%E7%94%B5%E7%AB%99%E7%87%83%E6%96%99%E6%B1%A0%E6%B0%B4%E6%BA%A2%E5%87%BA&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "9、当地时间1月1日，日本石川县能登地区的这次地震的震度为3，震级为4.6级。此前，日本气象厅发布的震度为7，但之后做了修正。",
                  "https://www.baidu.com/s?wd=%E6%97%A5%E6%9C%AC%E6%B0%94%E8%B1%A1%E5%8E%85%E4%BF%AE%E6%AD%A3%E6%9C%80%E6%96%B0%E4%B8%80%E6%AC%A1%E5%9C%B0%E9%9C%87%E9%9C%87%E5%BA%A6&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "10、近日，网传年仅20岁的机车网红欧可爱因车祸溺水身亡。1日，其家属称已安排火花遗体。亲友：她曾说要睡海里，不想一语成谶。",
                  "https://www.baidu.com/s?wd=%E7%BD%91%E7%BA%A2%E6%AC%A7%E5%8F%AF%E7%88%B1%E8%BD%A6%E7%A5%B8%E6%BA%BA%E6%B0%B4%E7%A6%BB%E4%B8%96+%E5%AE%B6%E5%B1%9E%E5%8F%91%E5%A3%B0&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "11、1月1日，受冷空气影响，黄淮到江南华南出现较大范围降温。6日起，各地自北向南气温将陆续转为偏低，小寒时节天气再度寒冷起来。",
                  "https://www.baidu.com/s?wd=%E5%9D%90%E7%A8%B3%E4%BA%86%EF%BC%81%E6%B0%94%E6%B8%A9%E2%80%9C%E8%BF%87%E5%B1%B1%E8%BD%A6%E2%80%9D%E5%8F%88%E8%A6%81%E5%8F%91%E8%BD%A6%E4%BA%86&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "12、1月1日，日本本州西岸近海发生7.4级地震。此次强震引发5米海啸，目前石川县轮岛港已观测到第一波浪高1.2米的海啸。",
                  "https://www.baidu.com/s?wd=%E6%97%A5%E6%9C%AC%E5%BC%BA%E9%9C%87%E5%90%8E%E7%AC%AC%E4%B8%80%E6%B3%A2%E6%B5%B7%E5%95%B8%E8%A2%AD%E6%9D%A5+%E6%B3%A2%E6%B6%9B%E6%BB%9A%E6%BB%9A&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "13、2023年12月31日晚，B站跨年晚会准时开播，网友直呼：B站跨年晚会赢麻了，十二位奥特英雄齐登场，各大二次元角色回归。",
                  "https://www.baidu.com/s?wd=B%E7%AB%99%E8%B7%A8%E5%B9%B4%E6%99%9A%E4%BC%9A%E8%B5%A2%E9%BA%BB%E4%BA%86&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "14、1月1日，记者问到蔡英文发表“两岸关系”相关的新年讲话时，国台办发言人陈斌华驳斥道：望台胞认清民进党路线、政策的危害性。",
                  "https://www.baidu.com/s?wd=%E8%94%A1%E8%8B%B1%E6%96%87%E5%8F%91%E8%A1%A8%E6%96%B0%E5%B9%B4%E8%AE%B2%E8%AF%9D+%E5%9B%BD%E5%8F%B0%E5%8A%9E%E9%A9%B3%E6%96%A5&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "15、近日，大量游客涌入哈尔滨，很多南方游客选择到洗浴中心进行体验，搓澡人数增多，网友调侃称这是南泥北搓。",
                  "https://www.baidu.com/s?wd=%E2%80%9C%E5%8D%97%E6%B3%A5%E5%8C%97%E6%90%93%E2%80%9D%E5%9C%BA%E9%9D%A2%E5%A3%AE%E8%A7%82&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "16、据中国地震台网测定，1月1日15时10分（当地16时10分）日本本州西岸近海发生7.4级地震，引发5米海啸，东京震感强烈。",
                  "https://www.baidu.com/s?wd=%E6%97%A5%E6%9C%AC%E8%BF%91%E6%B5%B7%E5%8F%91%E7%94%9F7.4%E7%BA%A7%E5%9C%B0%E9%9C%87&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "17、近日，广东一乡镇发布一则年度躺平休闲人员名单，并要求分类提出处置意见，引发关注。专家：评选“躺平者”的工作应谨慎。",
                  "https://www.baidu.com/s?wd=%E5%B9%BF%E4%B8%9C%E4%B8%80%E4%B9%A1%E9%95%87%E5%85%AC%E7%A4%BA8%E5%90%8D%E2%80%9C%E8%BA%BA%E5%B9%B3%E4%BC%91%E9%97%B2%E4%BA%BA%E5%91%98%E2%80%9D&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "18、2024年1月1日凌晨1时07分，伴随着“哇”的一声洪亮的啼哭，北京妇产医院迎来“新年宝宝”，叫“一博”。",
                  "https://www.baidu.com/s?wd=%E5%8C%97%E4%BA%AC2024%E5%B9%B4%E6%96%B0%E5%B9%B4%E5%AE%9D%E5%AE%9D%E5%8F%AB%E2%80%9C%E4%B8%80%E5%8D%9A%E2%80%9D&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "19、1月1日，日本本州西岸近海发生7●4级地震。受连续强震影响的日本多个地区正在确认核电站情况，目前，福井县报告称“无异常”。",
                  "https://www.baidu.com/s?wd=%E5%BC%BA%E9%9C%87%E5%90%8E%E6%97%A5%E6%9C%AC%E5%90%84%E5%9C%B0%E7%B4%A7%E6%80%A5%E7%A1%AE%E8%AE%A4%E6%A0%B8%E7%94%B5%E7%AB%99%E6%83%85%E5%86%B5&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "20、近日，不少网友吐槽雪乡酒店民宿住一晚动辄上千元，引发关注。对此，当地市监局回应：已派专人进行监管，严厉打击“阴阳价格”。",
                  "https://www.baidu.com/s?wd=%E5%B8%82%E7%9B%91%E5%B1%80%E5%9B%9E%E5%BA%94%E9%9B%AA%E4%B9%A1%E9%85%92%E5%BA%97%E4%BB%B7%E6%A0%BC%E5%A4%A7%E6%B6%A8&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "21、近日，郑州一男子称自己仅上班10天就被辞退，并且只收到45元工资，还被强迫签订无异议证明。监察部门：暂不清楚是否介入此事。",
                  "https://www.baidu.com/s?wd=%E5%B0%8F%E4%BC%99%E4%B8%8A%E7%8F%AD10%E5%A4%A9%E8%A2%AB%E8%BE%9E%E4%BB%85%E6%94%B6%E5%88%B045%E5%85%83%E5%B7%A5%E8%B5%84&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "22、1月1日，日本石川县能登地区发生7●6级强震，石川县警察本部当地时间2日上午5时宣布，地震造成该县共6人死亡。",
                  "https://www.baidu.com/s?wd=%E5%9C%B0%E9%9C%87%E5%B7%B2%E8%87%B4%E6%97%A5%E6%9C%AC%E7%9F%B3%E5%B7%9D%E5%8E%BF6%E4%BA%BA%E6%AD%BB%E4%BA%A1&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "23、近日，舞蹈科目三在网络上爆火，但网传的科目三都只是一小段魔性动作，有网友扒出科目三完整版舞蹈视频，发现后面还有高难度动作。",
                  "https://www.baidu.com/s?wd=%E7%A7%91%E7%9B%AE%E4%B8%89%E5%AE%8C%E6%95%B4%E7%89%88%E8%88%9E%E8%B9%88%E6%9B%9D%E5%85%89&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "24、1日，中国男足与中国香港队进行了一场封闭热身赛。国足先进一球却遭对手1—2逆转。王上源、吴少聪及一名教练组成员染红离场。",
                  "https://www.baidu.com/s?wd=%E6%96%B0%E5%B9%B4%E9%A6%96%E6%88%98%E5%9B%BD%E8%B6%B31-2%E4%B8%8D%E6%95%8C%E4%B8%AD%E5%9B%BD%E9%A6%99%E6%B8%AF&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "25、1月2日，韩国最大在野党党首李在明在韩国釜山出席活动时遇袭。韩国警方透露，李在明颈部有1厘米伤口，推断是轻伤。",
                  "https://www.baidu.com/s?wd=%E6%9D%8E%E5%9C%A8%E6%98%8E%E9%A2%88%E9%83%A8%E4%BC%A4%E5%8F%A31%E5%8E%98%E7%B1%B3+%E6%8E%A8%E6%96%AD%E6%98%AF%E8%BD%BB%E4%BC%A4&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "26、据韩媒报道，韩国共同民主党领袖李在明1月2日在釜山遇袭，据警方称，事件发生时周围部署约50名警员。",
                  "https://www.baidu.com/s?wd=%E6%9D%8E%E5%9C%A8%E6%98%8E%E9%81%87%E8%A2%AD%E6%97%B6%E8%BA%AB%E8%BE%B9%E6%9C%8950%E5%A4%9A%E5%90%8D%E8%AD%A6%E5%AF%9F&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "27、据日本媒体报道，截至当地时间1月2日13时47分，日本石川县内已有至少30人因1月1日的地震死亡。",
                  "https://www.baidu.com/s?wd=%E6%97%A5%E6%9C%AC%E5%9C%B0%E9%9C%87%E5%B7%B2%E8%87%B4%E8%87%B3%E5%B0%9130%E4%BA%BA%E6%AD%BB%E4%BA%A1&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "28、近日，六安市一玻璃窗从14楼坠落，孕妇被意外砸伤。经诊断孕妇多处受伤，为治疗不得不中止妊娠。",
                  "https://www.baidu.com/s?wd=%E5%AD%95%E5%A6%87%E8%A2%AB%E5%9D%A0%E7%AA%97%E7%A0%B8%E4%BC%A4%E5%90%8E%E4%B8%BA%E6%B2%BB%E7%96%97%E7%BB%88%E6%AD%A2%E5%A6%8A%E5%A8%A0&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "29、1月2日，泰国总理赛塔·他威信表示：中泰两国将从3月起永久互免对方公民签证。",
                  "https://www.baidu.com/s?wd=%E4%B8%AD%E6%B3%B03%E6%9C%88%E8%B5%B7%E6%B0%B8%E4%B9%85%E4%BA%92%E5%85%8D%E7%AD%BE%E8%AF%81&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "30、2日，浏阳创意焰火燃放活动指导中心发布通告称，因夜间气温较低，出于安全考虑，2024年春节前后将暂停举办周末焰火秀活动。",
                  "https://www.baidu.com/s?wd=%E6%B9%96%E5%8D%97%E6%B5%8F%E9%98%B3%E5%B0%86%E6%9A%82%E5%81%9C%E4%B8%BE%E5%8A%9E%E5%91%A8%E6%9C%AB%E7%84%B0%E7%81%AB%E7%A7%80&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "31、1月2日，湖南一货车与公交车在省道530线发生碰撞，事故导致4人死亡，7人受伤。目前，受伤人员正在医院救治，暂无生命危险。",
                  "https://www.baidu.com/s?wd=%E6%B9%96%E5%8D%97%E4%B8%80%E8%B4%A7%E8%BD%A6%E4%B8%8E%E5%85%AC%E4%BA%A4%E8%BD%A6%E7%A2%B0%E6%92%9E%E8%87%B44%E6%AD%BB7%E4%BC%A4&sa=fyb_news&rsv_dl=fyb_news"
                ],
                [
                  "【微语】为了你我把人生的高度设得那么高，以至于人间所有乐事对于我来说全是失落。",
                  ""
                ]
              ]
            }
            """.trimIndent()
        ).toModels()
    }

    suspend fun getNewsFromJuhe() =
        client.get("http://v.juhe.cn/toutiao/index?type=top&key=3dc86b09a2ee2477a5baa80ee70fcdf5")
            .body<NewsFromJuheDTO>()
            .toModels()


    suspend fun fakeGetNewsFromJuhe(): List<NewsModel> {
        delay(1000)
        return json.decodeFromString<NewsFromJuheDTO>("""
        {
            "reason": "success!",
            "result": {
                "stat": "1",
                "data": [
                    {
                        "uniquekey": "06edb3309669dd29b75f79f5f9451f5e",
                        "title": "潘庄灌区运行维护中心 全力保障引水安全",
                        "date": "2024-01-03 10:19:00",
                        "category": "头条",
                        "author_name": "每日看点快看",
                        "url": "https://mini.eastday.com/mobile/240103101900343155638.html",
                        "thumbnail_pic_s": "",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "33244a0c50d0482f4d4766ea3a81a504",
                        "title": "威海经区税务局：践行新时代“枫桥经验” 提升纳税服务质效",
                        "date": "2024-01-03 10:18:00",
                        "category": "头条",
                        "author_name": "中国网",
                        "url": "https://mini.eastday.com/mobile/240103101817229261082.html",
                        "thumbnail_pic_s": "",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "0f72ef05af3d4ab457a131b7118bc44a",
                        "title": "2024年元旦假期全国旅游人次达1.35亿元",
                        "date": "2024-01-03 10:16:00",
                        "category": "头条",
                        "author_name": "阿宅社会",
                        "url": "https://mini.eastday.com/mobile/240103101648872209114.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x337_6594c390809a0_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "d341001380c3dcf759daf7aec47d5fa9",
                        "title": "市民购物卡遗失一年多仍不能补办，多方协调后双方达成一致",
                        "date": "2024-01-03 10:16:00",
                        "category": "头条",
                        "author_name": "关注健康",
                        "url": "https://mini.eastday.com/mobile/240103101634260799049.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/1200x900_6594c381c2b4f_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "cb0464d0d94c6bc09389e87f688bfdd0",
                        "title": "以次充好、以旧代新，汽车维修陷阱怎么这么多？",
                        "date": "2024-01-03 10:15:00",
                        "category": "头条",
                        "author_name": "杭州网",
                        "url": "https://mini.eastday.com/mobile/240103101533761296896.html",
                        "thumbnail_pic_s": "",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "affa3d330bf689ab27579669880300ae",
                        "title": "桥柯牌子锣的传承与新生：300年文吹武打传7代",
                        "date": "2024-01-03 10:15:00",
                        "category": "头条",
                        "author_name": "关注健康",
                        "url": "https://mini.eastday.com/mobile/240103101529952116858.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/1200x913_6594c33f84701_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/1200x578_6594c3403f57e_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/minimodify/20240103/1200x911_6594c340dc6fa_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "6869c7e54640cb09125ae94bf1f2e04c",
                        "title": "“年度最大太阳”今日亮相 象限仪流星雨、双星伴月准备登场",
                        "date": "2024-01-03 10:15:00",
                        "category": "头条",
                        "author_name": "杭州网",
                        "url": "https://mini.eastday.com/mobile/240103101519016890942.html",
                        "thumbnail_pic_s": "",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "3b5571129286382a35c0aedf4864d46e",
                        "title": "女子退租房，房东却变卦了",
                        "date": "2024-01-03 10:15:00",
                        "category": "头条",
                        "author_name": "阿宅社会",
                        "url": "https://mini.eastday.com/mobile/240103101517196338026.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x335_6594c3331505d_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x340_6594c333b7f9e_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x344_6594c3343a90a_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "962ee85eae7da21971537d9efd6e6cc7",
                        "title": "跨年夜惠州一海滩留下满地烟花垃圾",
                        "date": "2024-01-03 10:14:00",
                        "category": "头条",
                        "author_name": "关注健康",
                        "url": "https://mini.eastday.com/mobile/240103101444958598496.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/496x692_6594c312b60e0_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x478_6594c3134d27b_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x482_6594c313f07b4_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "3f5fefb92abd7d27a8c60f217e1c3e26",
                        "title": "20余年累计节水4000余万吨，这所高校交上高质量节水答卷",
                        "date": "2024-01-03 10:14:00",
                        "category": "头条",
                        "author_name": "关注健康",
                        "url": "https://mini.eastday.com/mobile/240103101411102218549.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x436_6594c2f2af8f7_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "53d00a3eedd82cbbddbdb1806abf2d17",
                        "title": "跨界联名不停，武汉老字号玩出新花样",
                        "date": "2024-01-03 10:13:00",
                        "category": "头条",
                        "author_name": "关注健康",
                        "url": "https://mini.eastday.com/mobile/240103101338204898694.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x480_6594c2cfa4e69_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x480_6594c2d041be6_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/minimodify/20240103/1200x900_6594c2d10c1eb_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "cc08e0648f8db1916bd2c5a79f2bd5c7",
                        "title": "西双版纳餐馆一盘白灼虾价值108元市场监管局将持续监管",
                        "date": "2024-01-03 10:13:00",
                        "category": "头条",
                        "author_name": "阿宅社会",
                        "url": "https://mini.eastday.com/mobile/240103101329768743080.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x1063_6594c2c84bae2_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x383_6594c2c8c5f4a_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x621_6594c2c963a60_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "a2aee5a8585182403c3c8c630f726970",
                        "title": "性教育这堂课，不要等坏人来教",
                        "date": "2024-01-03 10:13:00",
                        "category": "头条",
                        "author_name": "中国青年报客户端",
                        "url": "https://mini.eastday.com/mobile/240103101312055486171.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/news/20240103/20240103101312_5cff6ccaa3d0e940e2d554aba4a86536_1_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "9c9ee6dcb9e382bd55fb46d712e74223",
                        "title": "长沙一流动摊贩非法从事设摊经营未明码标价等违法行为被处理",
                        "date": "2024-01-03 10:12:00",
                        "category": "头条",
                        "author_name": "阿宅社会",
                        "url": "https://mini.eastday.com/mobile/240103101232383762857.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x640_6594c28e79e26_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/469x453_6594c28f8fa95_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "32584844820b75debbc129f6d3f0de45",
                        "title": "线上办案+云上缴费 河北交通运输执法实现数字化转型",
                        "date": "2024-01-03 10:11:00",
                        "category": "头条",
                        "author_name": "东方资讯河北频道",
                        "url": "https://mini.eastday.com/mobile/240103101103014443395.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/720x444_6594c21990669_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/1024x766_6594c21f8b617_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/minimodify/20240103/720x405_6594c22555755_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "96b6879f34b64f46676cf9a4979a1517",
                        "title": "短时间内增长鸡脚蹬的方法   喂什么东西让鸡长脚蹬子",
                        "date": "2024-01-03 10:11:00",
                        "category": "头条",
                        "author_name": "星星养殖",
                        "url": "https://mini.eastday.com/mobile/240103101102830358551.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/1080x720_6594c23000b97_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "60eefcc6050247a1285d1ff37c886fbe",
                        "title": "杭州一小区停车场施工致地面塌陷，业主担心房屋安全",
                        "date": "2024-01-03 10:10:00",
                        "category": "头条",
                        "author_name": "阿宅社会",
                        "url": "https://mini.eastday.com/mobile/240103101058274537869.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x450_6594c2301c3c9_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x450_6594c2309d258_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x800_6594c23153369_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "ed2e3cf902e72be3e8ab85cce4d7bab2",
                        "title": "降雨降温难挡出游热，游客雨中打卡武汉",
                        "date": "2024-01-03 10:09:00",
                        "category": "头条",
                        "author_name": "关注健康",
                        "url": "https://mini.eastday.com/mobile/240103100940846302228.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x426_6594c1e279d2b_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x426_6594c1e3366f9_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x426_6594c1e3b196d_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "5b5baf4002a134fb8097cd2a121e3fc3",
                        "title": "最炫民族风单板滑雪，帅不？",
                        "date": "2024-01-03 10:09:00",
                        "category": "头条",
                        "author_name": "关注健康",
                        "url": "https://mini.eastday.com/mobile/240103100908592834108.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x361_6594c1c4230f4_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "50982832dd9214f2714cb4e189050e83",
                        "title": "2023影像盘点 | 街头写意—摄影师 张勇（南京）",
                        "date": "2024-01-03 10:09:00",
                        "category": "头条",
                        "author_name": "上游新闻",
                        "url": "https://mini.eastday.com/mobile/240103100908240364723.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/news/20240103/20240103100908_2a1e26a7bf285bc0596bbde6362ad722_1_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/news/20240103/20240103100908_2a1e26a7bf285bc0596bbde6362ad722_2_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/news/20240103/20240103100908_2a1e26a7bf285bc0596bbde6362ad722_3_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "5f12be9553e6a1531fdcb95b0b82fbd8",
                        "title": "元旦假期游客量同比增长四成，黄冈文旅迎来开门红",
                        "date": "2024-01-03 10:07:00",
                        "category": "头条",
                        "author_name": "关注健康",
                        "url": "https://mini.eastday.com/mobile/240103100728918861184.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x453_6594c15ee4f33_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x523_6594c15fcdc8b_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/minimodify/20240103/640x361_6594c16084724_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "13312aff35ab39a5e916df2be76ebe3e",
                        "title": "立个flag 期许美好生活",
                        "date": "2024-01-03 10:06:00",
                        "category": "头条",
                        "author_name": "每日看点快看",
                        "url": "https://mini.eastday.com/mobile/240103100659053381300.html",
                        "thumbnail_pic_s": "",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "d121f179c51a6e7497dfde70a0a0e1e8",
                        "title": "元旦假期出行分析",
                        "date": "2024-01-03 10:06:00",
                        "category": "头条",
                        "author_name": "阿宅社会",
                        "url": "https://mini.eastday.com/mobile/240103100631161784957.html",
                        "thumbnail_pic_s": "",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "ceba17cf17bebc33acfa25298105a3f4",
                        "title": "“爱心粥铺”情暖一座城",
                        "date": "2024-01-03 10:06:00",
                        "category": "头条",
                        "author_name": "每日看点快看",
                        "url": "https://mini.eastday.com/mobile/240103100625426556290.html",
                        "thumbnail_pic_s": "",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "e12d6113ea2ec2059973a8d254366ad9",
                        "title": "武两高速平桥隧道顺利贯通武两高速重难点控制性工程",
                        "date": "2024-01-03 10:05:00",
                        "category": "头条",
                        "author_name": "阿宅社会",
                        "url": "https://mini.eastday.com/mobile/240103100557304875252.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x450_6594c104ca190_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "cf6b14109b3971f228131e6d1bf87cfc",
                        "title": "陕西合阳冬日韵味浓浓",
                        "date": "2024-01-03 10:05:00",
                        "category": "头条",
                        "author_name": "阿宅社会",
                        "url": "https://mini.eastday.com/mobile/240103100528841850453.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x337_6594c0e6a37c3_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x337_6594c0e756132_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/minimodify/20240103/600x333_6594c0e7d6b43_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "42a2a82b4412e504082a895a3f6a9756",
                        "title": "黄石步行街提前亮相，成最新网红打卡地",
                        "date": "2024-01-03 10:05:00",
                        "category": "头条",
                        "author_name": "关注健康",
                        "url": "https://mini.eastday.com/mobile/240103100508732692926.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/1200x900_6594c0d215d5a_mwpm_03201609.jpeg",
                        "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/minimodify/20240103/1200x900_6594c0d3105c4_mwpm_03201609.jpeg",
                        "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/minimodify/20240103/1200x900_6594c0d3ab118_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "3d1229eae6af3a8b4ee5833e647caa85",
                        "title": "安国市：快递外卖小哥有了“暖心屋”",
                        "date": "2024-01-03 10:04:00",
                        "category": "头条",
                        "author_name": "每日看点快看",
                        "url": "https://mini.eastday.com/mobile/240103100456746168143.html",
                        "thumbnail_pic_s": "",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "4bb4629d830ec113d36f8fb30fec9d33",
                        "title": "武汉径河执法路长捡到手机，寒夜原地苦等一个多小时完璧归赵",
                        "date": "2024-01-03 10:04:00",
                        "category": "头条",
                        "author_name": "关注健康",
                        "url": "https://mini.eastday.com/mobile/240103100439781392697.html",
                        "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/minimodify/20240103/1200x656_6594c0b743560_mwpm_03201609.jpeg",
                        "is_content": "1"
                    },
                    {
                        "uniquekey": "8c855f3cec7a1d80ba8588edce80fe08",
                        "title": "为了一句承诺 小伙义务救援百余次",
                        "date": "2024-01-03 10:04:00",
                        "category": "头条",
                        "author_name": "每日看点快看",
                        "url": "https://mini.eastday.com/mobile/240103100425611288105.html",
                        "thumbnail_pic_s": "",
                        "is_content": "1"
                    }
                ],
                "page": "1",
                "pageSize": "30"
            },
            "error_code": 0
        }
        """.trimIndent()).toModels()
    }

}