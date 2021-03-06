package org.xyafu.app.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import org.xyafu.app.R;
import org.xyafu.app.activity.MusicDetailActivity;
import org.xyafu.app.adpater.MyAdapter;
import org.xyafu.app.pojo.Music_mes;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageMusic extends Fragment implements AdapterView.OnItemClickListener {
    private ArrayList<Music_mes> data;
    private FragmentManager manager;
    private ListView listView;
    private String[] m_names={"这一生关于你的风景","明智之举","战放","慕夏",
            "光年之外","Lemon","消愁","浅唱","暧昧","老街","燕归巢","成都"};
    private String[] m_pres={"枯木逢春","许嵩","本兮","等什么君",
            "邓紫棋","米津玄师","毛不易","许嵩,Dior","薛之谦","李荣浩","许嵩","赵雷"};
    private String[] m_music=new String[14];
    private int [] m_img=new int[14];
    private int[] music=new int[14];
    public PageMusic() {
        // Required empty public constructor
    }

    public PageMusic(ArrayList<Music_mes> data, FragmentManager manager) {
        this.data = data;
        this.manager = manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_page_music,null);
        listView=view.findViewById(R.id.mu_list);
        m_imgs();
        m_musics();
        data = new ArrayList<>();
        for( int i = 0; i <m_names.length ; i++) {
            Music_mes music_mes = new Music_mes();
            music_mes.setMusic_name(m_names[i]);
            music_mes.setMusic_person(m_pres[i]);
            music_mes.setMusic_img(m_img[i]);
            m_music[i]=geci(i);
            data.add(music_mes);
        }
        
        MyAdapter myAdapter = new MyAdapter(data, getActivity());
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("name",m_names[position]);
        intent.putExtra("person",m_pres[position]);
        intent.putExtra("music",m_music[position]);
        intent.putExtra("music_s",music[position]);
        intent.setClass(getActivity(), MusicDetailActivity.class);
        startActivity(intent);
    }

    public String geci(int p){
        String str="";
        switch (p){
            case 0:
                str="远方灯火闪亮着光\n" +
                        "你一人低头在路上\n" +
                        "这城市越大越让人心慌\n" +
                        "多向往\n" +
                        "多漫长\n" +
                        "这一路经历太多伤\n" +
                        "把最初笑容都淡忘\n" +
                        "时光让我们变得脆弱且坚强\n" +
                        "让我再来轻轻对你唱\n" +
                        "我多想 能多陪你一场\n" +
                        "把前半生的风景对你讲\n" +
                        "在每个寂静的夜里我会想\n" +
                        "那些关于你的爱恨情长\n" +
                        "我也想 能够把你照亮\n" +
                        "在你的生命中留下阳光\n" +
                        "陪你走过那山高水长\n" +
                        "陪你一起生长\n" +
                        "远方灯火闪亮着光\n" +
                        "你一人低头在路上\n" +
                        "这城市越大越让人心慌\n" +
                        "多向往\n" +
                        "多漫长\n" +
                        "这一路经历太多伤\n" +
                        "把最初笑容都淡忘\n" +
                        "时光让我们变得脆弱且坚强\n" +
                        "让我再来轻轻对你唱\n" +
                        "我多想 能多陪你一场\n" +
                        "把前半生的风景对你讲\n" +
                        "在每个寂静的夜里我会想\n" +
                        "那些关于你的爱恨情长\n" +
                        "我也想 能够把你照亮\n" +
                        "在你的生命中留下阳光\n" +
                        "陪你走过那山高水长\n" +
                        "陪你一起生长\n" +
                        "这一生在你的风景里\n" +
                        "我是谁";
                return str;
            case 1:
                str="你在北方某城 很偶尔下雨\n" +
                        "我在天南海北 很偶尔想你\n" +
                        "写不来十八九岁煽情字句\n" +
                        "孤单喂饱了理性\n" +
                        "想必你也看过了一些风景\n" +
                        "才明白什么样的适合自己\n" +
                        "翻着你朋友圈的幸福合影\n" +
                        "由衷的为你高兴\n" +
                        "我曾在意的你\n" +
                        "想说声对不起\n" +
                        "年少时的任性\n" +
                        "有些话伤人不轻\n" +
                        "也怀疑自己\n" +
                        "不是理想伴侣\n" +
                        "你的离开也许是个明智之举\n" +
                        "我曾在意的你\n" +
                        "给过太多悲喜\n" +
                        "承蒙时光洗礼\n" +
                        "往事已云淡风轻\n" +
                        "当我们老去\n" +
                        "品尝丰盛回忆\n" +
                        "每一道失去都是醇厚的赐予\n" +
                        "你在北方某城 很偶尔下雨\n" +
                        "我在天南海北 很偶尔想你\n" +
                        "写不来十八九岁煽情字句\n" +
                        "孤单喂饱了理性\n" +
                        "想必你也看过了一些风景\n" +
                        "才明白什么样的适合自己\n" +
                        "翻着你朋友圈的幸福合影\n" +
                        "由衷的为你高兴\n" +
                        "我曾在意的你\n" +
                        "想说声对不起\n" +
                        "年少时的任性\n" +
                        "有些话伤人不轻\n" +
                        "也怀疑自己\n" +
                        "不是理想伴侣\n" +
                        "你的离开也许是个明智之举\n" +
                        "我曾在意的你\n" +
                        "给过太多悲喜\n" +
                        "承蒙时光洗礼\n" +
                        "往事已云淡风轻\n" +
                        "当我们老去\n" +
                        "品尝丰盛回忆\n" +
                        "每一道失去\n" +
                        "你曾笑着问我\n" +
                        "如若重新来过\n" +
                        "结局会不会不同\n" +
                        "我出神了许久\n" +
                        "神游在初见的午后\n" +
                        "我曾在意的你\n" +
                        "想说声对不起\n" +
                        "年少时的任性\n" +
                        "有些话伤人不轻\n" +
                        "也怀疑自己\n" +
                        "不是理想伴侣\n" +
                        "你的离开也许是个明智之举\n" +
                        "我曾在意的你\n" +
                        "给过太多悲喜\n" +
                        "承蒙时光洗礼\n" +
                        "往事已云淡风轻\n" +
                        "当我们老去\n" +
                        "品尝丰盛回忆\n" +
                        "每一道失去\n" +
                        "都是醇厚的赐予";
                return str;
            case 2:
                str="避开你目光 躲 躲 躲 回头\n" +
                        "面对面无情地交锋\n" +
                        "怎样的花火\n" +
                        "我享受禁区悦耳的 爆破\n" +
                        "刀锋在致命点划过\n" +
                        "我是你的噩梦 掠夺你所有\n" +
                        "未知的命运\n" +
                        "令我着迷\n" +
                        "找寻无尽的刺激\n" +
                        "是我的使命\n" +
                        "紧绷的神经\n" +
                        "零距离苏醒\n" +
                        "描绘 血花在胸前 战放的美丽\n" +
                        "在战场上用猫步行走\n" +
                        "优雅地出现在你身前身后\n" +
                        "瞬间给予致命的温柔\n" +
                        "死亡的恐惧在你毙命之后\n" +
                        "避开你目光 躲 躲 躲 回头\n" +
                        "面对面无情地交锋\n" +
                        "怎样的花火\n" +
                        "我享受禁区悦耳的 爆破\n" +
                        "刀锋在致命点划过\n" +
                        "我是你的噩梦 掠夺你所有\n" +
                        "躲 躲 躲 回头\n" +
                        "面对面无情地交锋\n" +
                        "怎样的花火\n" +
                        "我享受禁区悦耳的 爆破\n" +
                        "刀锋在致命点划过\n" +
                        "我是你的噩梦 掠夺你所有\n" +
                        "未知的命运\n" +
                        "令我着迷\n" +
                        "找寻无尽的刺激\n" +
                        "是我的使命\n" +
                        "紧绷的神经\n" +
                        "零距离苏醒\n" +
                        "描绘 血花在胸前 战放的美丽\n" +
                        "在战场上用猫步行走\n" +
                        "优雅地出现在你身前身后\n" +
                        "瞬间给予致命的温柔\n" +
                        "死亡的恐惧在你毙命之后\n" +
                        "避开你目光 躲 躲 躲 回头\n" +
                        "面对面无情地交锋\n" +
                        "怎样的花火\n" +
                        "我享受禁区悦耳的 爆破\n" +
                        "刀锋在致命点划过\n" +
                        "我是你的噩梦 掠夺你所有\n" +
                        "躲 躲 躲 回头\n" +
                        "面对面无情地交锋\n" +
                        "怎样的花火\n" +
                        "我享受禁区悦耳的 爆破\n" +
                        "刀锋在致命点划过\n" +
                        "我是你的噩梦\n" +
                        "避开你目光 躲 躲 躲 回头\n" +
                        "面对面无情地交锋\n" +
                        "怎样的花火\n" +
                        "我享受禁区悦耳的 爆破\n" +
                        "刀锋在致命点划过\n" +
                        "我是你的噩梦 掠夺你所有\n" +
                        "躲 躲 躲 回头\n" +
                        "面对面无情地交锋\n" +
                        "怎样的花火\n" +
                        "我享受禁区悦耳的 爆破\n" +
                        "刀锋在致命点划过\n" +
                        "我是你的噩梦 掠夺你所有";
                return str;
            case 3:
                str="银辉描淡的石桥\n" +
                        "桥边嬉戏的垂髫\n" +
                        "风吹枝柳折细腰\n" +
                        "童谣声声伴长吆\n" +
                        "乌蓬水面风寂寥\n" +
                        "薄云淡淡月初瞧\n" +
                        "江上画舫熏香绕\n" +
                        "灯暖酒烫知己邀\n" +
                        "西月东落天色微曜\n" +
                        "半樽清酒斟得逍遥\n" +
                        "白衣纵马风流年少\n" +
                        "佳人倾城回眸浅笑\n" +
                        "玉笛声声月色皎皎\n" +
                        "起舞翩翩清影窈窕\n" +
                        "姻缘树下共求月老\n" +
                        "执手暮暮朝朝\n" +
                        "长夜温柔萤光照\n" +
                        "满城锦绣灯火耀\n" +
                        "老街小巷复喧嚣\n" +
                        "戏台风月增新貌\n" +
                        "轻纱遮面舞灵巧\n" +
                        "琵琶绕梁音袅袅\n" +
                        "唱罢西厢客醉笑\n" +
                        "推杯换盏度良宵\n" +
                        "西月东落天色微曜\n" +
                        "半樽清酒斟得逍遥\n" +
                        "白衣纵马风流年少\n" +
                        "佳人倾城回眸浅笑\n" +
                        "玉笛声声月色皎皎\n" +
                        "起舞翩翩清影窈窕\n" +
                        "姻缘树下共求月老\n" +
                        "执手暮暮朝朝\n" +
                        "西月东落天色微曜\n" +
                        "半樽清酒斟得逍遥\n" +
                        "白衣纵马风流年少\n" +
                        "佳人倾城回眸浅笑\n" +
                        "玉笛声声月色皎皎\n" +
                        "起舞翩翩清影窈窕\n" +
                        "姻缘树下共求月老\n" +
                        "执手暮暮朝朝";
                return str;
            case 4:
                str="感受停在我发端的指尖\n" +
                        "如何瞬间冻结时间\n" +
                        "记住望着我坚定的双眼\n" +
                        "也许已经没有明天\n" +
                        "面对浩瀚的星海\n" +
                        "我们微小得像尘埃\n" +
                        "漂浮在一片无奈\n" +
                        "缘分让我们相遇乱世以外\n" +
                        "命运却要我们危难中相爱\n" +
                        "也许未来遥远在光年之外\n" +
                        "我愿守候未知里为你等待\n" +
                        "我没想到为了你我能疯狂到\n" +
                        "山崩海啸没有你根本不想逃\n" +
                        "我的大脑为了你已经疯狂到\n" +
                        "脉搏心跳没有你根本不重要\n" +
                        "一双围在我胸口的臂弯\n" +
                        "足够抵挡天旋地转\n" +
                        "一种执迷不放手的倔强\n" +
                        "足以点燃所有希望\n" +
                        "宇宙磅礴而冷漠\n" +
                        "我们的爱微小却闪烁\n" +
                        "颠簸却如此忘我\n" +
                        "\n" +
                        "缘分让我们相遇乱世以外\n" +
                        "命运却要我们危难中相爱\n" +
                        "也许未来遥远在光年之外\n" +
                        "我愿守候未知里为你等待\n" +
                        "我没想到为了你我能疯狂到\n" +
                        "山崩海啸没有你根本不想逃\n" +
                        "我的大脑为了你已经疯狂到\n" +
                        "脉搏心跳没有你根本不重要\n" +
                        "也许航道以外是醒不来的梦\n" +
                        "乱世以外是纯粹的相拥\n" +
                        "我没想到为了你我能疯狂到\n" +
                        "山崩海啸没有你根本不想逃\n" +
                        "我的大脑为了你已经疯狂到\n" +
                        "脉搏心跳没有你根本不重要\n" +
                        "相遇乱世以外危难中相爱\n" +
                        "相遇乱世以外危难中相爱\n" +
                        "我没想到";
                return str;
            case 5:
                str="梦(ゆめ)ならばどれほどよかったでしょう\n" +
                        "未(いま)だにあなたのことを梦(ゆめ)にみる\n" +
                        "忘(わす)れた物(もの)を取(と)りに帰(かえ)るように\n" +
                        "古(ふる)びた思(おも)い出(で)の埃(ほこり)を払(はら)う\n" +
                        "戻(もど)らない幸(しあわ)せがあることを\n" +
                        "最後(さいご)にあなたが教(おし)えてくれた\n" +
                        "言(い)えずに隠(かく)してた昏(くら)い过去(かこ)も\n" +
                        "あなたがいなきゃ永远(えいえん)に昏(くら)いまま\n" +
                        "きっともうこれ以上(いじょう) 伤(きず)つくことなど\n" +
                        "ありはしないとわかっている\n" +
                        "あの日(ひ)の悲(かな)しみさえ\n" +
                        "あの日(ひ)の苦(くる)しみさえ\n" +
                        "そのすべてを爱(あい)してた あなたとともに\n" +
                        "胸(むね)に残(のこ)り离(はな)れない\n" +
                        "苦(にが)いレモン(れもん)の匂(にお)い\n" +
                        "雨(あめ)が降(ふ)り止(や)むまでは帰(かえ)れない\n" +
                        "今(いま)でもあなたはわたしの光(ひかり)\n" +
                        "暗闇(くらやみ)であなたの背(せ)をなぞった\n" +
                        "その轮廓(りんかく)を鲜明(せんめい)に覚(おぼ)えている\n" +
                        "受(う)け止(と)めきれないものと出会(であ)うたび\n" +
                        "溢(あふ)れてやまないのは涙(なみだ)だけ\n" +
                        "何(なに)をしていたの\n" +
                        "何(なに)を见(み)ていたの\n" +
                        "わたしの知(し)らない横颜(よこがお)で\n" +
                        "どこかであなたが今(いま)\n" +
                        "わたしと同(おな)じ様(よう)な\n" +
                        "涙(なみだ)にくれ 淋(さび)しさの中(なか)にいるなら\n" +
                        "わたしのことなどどうか 忘(わす)れてください\n" +
                        "そんなことを心(こころ)から愿(ねが)うほどに\n" +
                        "今(いま)でもあなたはわたしの光(ひかり)\n" +
                        "自分(じぶん)が思(おも)うより 恋(こい)をしていたあなたに\n" +
                        "あれから思(おも)うように 息(いき)ができない\n" +
                        "あんなに侧(そば)にいたのにまるで嘘(うそ)みたい\n" +
                        "とても忘(わす)れられないそれだけが确(たし)か\n" +
                        "あの日(ひ)の悲(かな)しみさえ\n" +
                        "あの日(ひ)の苦(くる)しみさえ\n" +
                        "その全(すべ)てを爱(あい)してたあなたと共(とも)に\n" +
                        "胸(むね)に残(のこ)り离(はな)れない\n" +
                        "苦(にが)いレモン(れもん)の匂(にお)い\n" +
                        "雨(あめ)が降(ふ)り止(や)むまでは帰(かえ)れない\n" +
                        "切(き)り分(わ)けた果実(かじつ)の片方(かたほう)の様(よう)に\n" +
                        "今(いま)でもあなたはわたしの光(ひかり)";
                return str;
            case 6:
                str="当你走进这欢乐场\n" +
                        "背上所有的梦与想\n" +
                        "各色的脸上各色的妆\n" +
                        "没人记得你的模样\n" +
                        "三巡酒过你在角落\n" +
                        "固执的唱着苦涩的歌\n" +
                        "听它在喧嚣里被淹没\n" +
                        "你拿起酒杯对自己说\n" +
                        "一杯敬朝阳 一杯敬月光\n" +
                        "唤醒我的向往 温柔了寒窗\n" +
                        "于是可以不回头地逆风飞翔\n" +
                        "不怕心头有雨 眼底有霜\n" +
                        "一杯敬故乡 一杯敬远方\n" +
                        "守着我的善良 催着我成长\n" +
                        "所以南北的路从此不再漫长\n" +
                        "灵魂不再无处安放\n" +
                        "躁动不安的座上客\n" +
                        "自以为是地表演着\n" +
                        "伪装着 舞蹈着 疲惫着\n" +
                        "你拿起酒杯对自己说\n" +
                        "一杯敬朝阳 一杯敬月光\n" +
                        "唤醒我的向往 温柔了寒窗\n" +
                        "于是可以不回头地逆风飞翔\n" +
                        "不怕心头有雨 眼底有霜\n" +
                        "一杯敬故乡 一杯敬远方\n" +
                        "守着我的善良 催着我成长\n" +
                        "所以南北的路从此不再漫长\n" +
                        "灵魂不再无处安放\n" +
                        "一杯敬明天 一杯敬过往\n" +
                        "支撑我的身体 厚重了肩膀\n" +
                        "虽然从不相信所谓山高水长\n" +
                        "人生苦短何必念念不忘\n" +
                        "一杯敬自由 一杯敬死亡\n" +
                        "宽恕我的平凡 驱散了迷惘\n" +
                        "好吧天亮之后总是潦草离场\n" +
                        "清醒的人最荒唐\n" +
                        "清醒的人最荒唐";
                return str;
            case 7:
                str="dior:无所谓该放就放别让自己那么累\n" +
                        "无所谓自由自在的飞让梦纯粹静候轮回\n" +
                        "一场大雨落在离我很远的空间很远的时间\n" +
                        "躲在静好的时光里面认真的学习着遗忘\n" +
                        "选择那些大晴天的日子行走在孤单的海岸线\n" +
                        "浅浅的唱歌给自己听\n" +
                        "一个人也要清醒决绝的走下去\n" +
                        "vae:阳光暖暖的时光慢慢的\n" +
                        "我是蔚蓝的在静好的岁月边缘张望着\n" +
                        "你能感应的项链断掉了\n" +
                        "爱情渐远着泪水在草地上和露水吻着\n" +
                        "徘徊在海岸线日出会在几点\n" +
                        "三三两两在离别承诺不兑现\n" +
                        "vae+dior:我说vae 你要清醒别再轻易掉眼泪\n" +
                        "我说vae 是是非非你要勇敢去面对\n" +
                        "我说vae 该放就放别让自己那么累\n" +
                        "无所谓自由自在的飞让梦纯粹静候轮回\n" +
                        "vae:徘徊在海岸线日出会在几点\n" +
                        "三三两两在离别承诺不兑现\n" +
                        "vae+dior:我说vae 你要清醒别再轻易掉眼泪\n" +
                        "我说vae 是是非非你要勇敢去面对\n" +
                        "我说vae 该放就放别让自己那么累\n" +
                        "无所谓自由自在的飞让梦纯粹静候轮回\n" +
                        "我说vae 你要清醒别再轻易掉眼泪\n" +
                        "我说vae 是是非非你要勇敢去面对\n" +
                        "我说vae 该放就放别让自己那么累\n" +
                        "无所谓自由自在的飞让梦纯粹静候轮回";
                return str;
            case 8:
                str="反正现在的感情 都暧昧\n" +
                        "你大可不必为难 找般配\n" +
                        "\n" +
                        "付出过的人排队 谈体会\n" +
                        "趁年轻 别害怕一个人睡\n" +
                        "可能是现在感情 太昂贵\n" +
                        "让付出真心的人 好狼狈\n" +
                        "还不如听首情歌 的机会\n" +
                        "忘了谁\n" +
                        "感情像牛奶一杯\n" +
                        "越甜越让人生畏\n" +
                        "都早有些防备\n" +
                        "润色前的原味\n" +
                        "所以人们都拿起咖啡\n" +
                        "把试探放在两人位\n" +
                        "距离感一对\n" +
                        "就不必再赤裸相对\n" +
                        "反正现在的感情 都暧昧\n" +
                        "你大可不必为难 找般配\n" +
                        "付出过的人排队 谈体会\n" +
                        "弃之可惜 食而无味\n" +
                        "可能是现在感情 太珍贵\n" +
                        "让付出真心的人 好疲惫\n" +
                        "谁不曾用过卑微的词汇\n" +
                        "想留住谁\n" +
                        "还贪恋着衣衫昂贵\n" +
                        "却输给了廉价香水\n" +
                        "他先诱你入位\n" +
                        "还刻意放低了分贝\n" +
                        "可感情越爱越妩媚\n" +
                        "像烂掉的苹果一堆\n" +
                        "连基因都不对\n" +
                        "还在意什么鱼腥味\n" +
                        "反正现在的感情 都暧昧\n" +
                        "你大可不必为难 找般配\n" +
                        "何必给自己沉迷 的机会\n" +
                        "不如用误会来结尾\n" +
                        "薛之谦 暧昧\n" +
                        "薛之谦 暧昧(4张)\n" +
                        "反正现在的我们 算暧昧\n" +
                        "我愿意给的感情 请浪费\n" +
                        "反正流过的眼泪 难收回\n" +
                        "就别再安慰\n" +
                        "看你入眠的侧脸 有多美\n" +
                        "和你丢下的一切 好匹配\n" +
                        "我还以为我能 多狼狈\n" +
                        "我自以为";
                return str;
            case 9:
                str="一张褪色的照片\n" +
                        "好像带给我一点点怀念\n" +
                        "巷尾老爷爷卖的热汤面\n" +
                        "味道弥漫过旧旧的后院\n" +
                        "流浪猫睡熟在摇晃秋千\n" +
                        "夕阳照了一遍他眯着眼\n" +
                        "那张同桌寄的明信片\n" +
                        "安静的躺在课桌的里面\n" +
                        "快要过完的春天\n" +
                        "还有雕刻着图案的门帘\n" +
                        "窄窄的长长的过道两边\n" +
                        "老房子依然升起了炊烟\n" +
                        "刚刚下完了小雨的季节\n" +
                        "爸妈又一起走过的老街\n" +
                        "巡回演出上海站\n" +
                        "巡回演出上海站(12张)\n" +
                        "记不得哪年的哪一天\n" +
                        "很漫长又很短暂的岁月\n" +
                        "现在已经回不去\n" +
                        "早已流逝的光阴\n" +
                        "手里的那一张渐渐模糊不清的车票\n" +
                        "成了回忆的信号\n" +
                        "忘不掉的是什么我也不知道\n" +
                        "想不起当年模样\n" +
                        "看也看不到 去也去不了的地方\n" +
                        "也许那老街的腔调是属于我的忧伤\n" +
                        "嘴角那点微笑越来越勉强\n" +
                        "忘不掉的是什么我也不知道\n" +
                        "放不下熟悉片段\n" +
                        "回头望一眼 已经很多年的时间\n" +
                        "透过手指间看着天\n" +
                        "我又回到那老街\n" +
                        "靠在你们身边渐行渐远\n" +
                        "快要过完的春天\n" +
                        "还有雕刻着图案的门帘\n" +
                        "窄窄的长长的过道两边\n" +
                        "老房子依然升起了炊烟\n" +
                        "刚刚下完了小雨的季节\n" +
                        "爸妈又一起走过的老街\n" +
                        "记不得哪年的哪一天\n" +
                        "很漫长又很短暂的岁月\n" +
                        "现在已经回不去\n" +
                        "早已流逝的光阴\n" +
                        "手里的那一张渐渐模糊不清的车票\n" +
                        "成了回忆的信号\n" +
                        "忘不掉的是什么我也不知道\n" +
                        "想不起当年模样\n" +
                        "看也看不到 去也去不了的地方\n" +
                        "也许那老街的腔调是属于我的忧伤\n" +
                        "嘴角那点微笑越来越勉强\n" +
                        "忘不掉的是什么我也不知道\n" +
                        "放不下熟悉片段\n" +
                        "回头望一眼 已经很多年的时间\n" +
                        "透过手指间看着天\n" +
                        "我又回到那老街\n" +
                        "靠在你们身边渐行渐远";
                return str;
            case 10:
                str="雨后江岸天破晓\n" +
                        "老舟新客知多少\n" +
                        "远山见竹林芳草\n" +
                        "晨风抚绿了芭蕉\n" +
                        "寒梅落尽把冬了\n" +
                        "衔春的燕想归巢\n" +
                        "沿途的景 牵挂的人\n" +
                        "两情迢迢\n" +
                        "柳叶桨溅桃花浪\n" +
                        "汀州里鹤眺远方\n" +
                        "饮一盏岁月留香\n" +
                        "唱一曲往事飞扬\n" +
                        "山水间歌声回荡\n" +
                        "回荡思念的滚烫\n" +
                        "去年的家书两行\n" +
                        "读来又热了眼眶\n" +
                        "云水边静沐暖阳\n" +
                        "烟波里久违的故乡\n" +
                        "别来无恙\n" +
                        "你在心上\n" +
                        "柳叶桨溅桃花浪\n" +
                        "汀州里鹤眺远方\n" +
                        "饮一盏岁月留香\n" +
                        "唱一曲往事飞扬\n" +
                        "山水间歌声回荡\n" +
                        "回荡思念的滚烫\n" +
                        "去年的家书两行\n" +
                        "读来又热了眼眶\n" +
                        "云水边静沐暖阳\n" +
                        "烟波里久违的故乡\n" +
                        "别来无恙\n" +
                        "你在心上\n" +
                        "儿时的窗 苍老的墙\n" +
                        "是否偷换了方向\n" +
                        "堂前的你和我相逢时\n" +
                        "会沉默还是会诉尽衷肠\n" +
                        "山水间歌声回荡\n" +
                        "回荡思念的滚烫\n" +
                        "去年的家书两行\n" +
                        "读来又热了眼眶\n" +
                        "云水边静沐暖阳\n" +
                        "烟波里久违的故乡\n" +
                        "别来无恙\n" +
                        "你在心上\n" +
                        "别来无恙\n" +
                        "你在心上";
                return str;
            case 11:
                str="让我掉下眼泪的 不止昨夜的酒\n" +
                        "让我依依不舍的 不止你的温柔\n" +
                        "余路还要走多久 你攥着我的手\n" +
                        "让我感到为难的 是挣扎的自由\n" +
                        "分别总是在九月 回忆是思念的愁\n" +
                        "深秋嫩绿的垂柳 亲吻着我额头\n" +
                        "在那座阴雨的小城里 我从未忘记你\n" +
                        "成都 带不走的 只有你\n" +
                        "和我在成都的街头走一走 喔…\n" +
                        "直到所有的灯都熄灭了也不停留\n" +
                        "你会挽着我的衣袖 我会把手揣进裤兜\n" +
                        "走到玉林路的尽头 坐在小酒馆的门口\n" +
                        "分别总是在九月 回忆是思念的愁\n" +
                        "深秋嫩绿的垂柳 亲吻着我额头\n" +
                        "在那座阴雨的小城里 我从未忘记你\n" +
                        "成都 带不走的 只有你\n" +
                        "和我在成都的街头走一走 喔…\n" +
                        "直到所有的灯都熄灭了也不停留\n" +
                        "你会挽着我的衣袖 我会把手揣进裤兜\n" +
                        "走到玉林路的尽头 坐在小酒馆的门口\n" +
                        "和我在成都的街头走一走 喔…\n" +
                        "直到所有的灯都熄灭了也不停留\n" +
                        "和我在成都的街头走一走 喔…\n" +
                        "直到所有的灯都熄灭了也不停留\n" +
                        "你会挽着我的衣袖 我会把手揣进裤兜\n" +
                        "走到玉林路的尽头 走过小酒馆的门口";
                return str;
        }
        return str;
    }
    public void m_imgs(){
        m_img[0]=R.drawable.music01;
        m_img[1]=R.drawable.music03;
        m_img[2]=R.drawable.music04;
        m_img[3]=R.drawable.music05;
        m_img[4]=R.drawable.music07;
        m_img[5]=R.drawable.music08;
        m_img[6]=R.drawable.music09;
        m_img[7]=R.drawable.music10;
        m_img[8]=R.drawable.music11;
        m_img[9]=R.drawable.music12;
        m_img[10]=R.drawable.music13;
        m_img[11]=R.drawable.music14;
    }
    public void m_musics(){
        music[0]=R.raw.music01;
        music[1]=R.raw.music03;
        music[2]=R.raw.music04;
        music[3]=R.raw.music05;
        music[4]=R.raw.music07;
        music[5]=R.raw.music08;
        music[6]=R.raw.music09;
        music[7]=R.raw.music10;
        music[8]=R.raw.music11;
        music[9]=R.raw.music12;
        music[10]=R.raw.music13;
        music[11]=R.raw.music14;
    }

}
