��Ŀ��ɽṹ��
dx.bat : ������.class �ļ����һ��.dex�ļ�
aapt : AndroidӦ�ô������
adb : Android������
doc : Ŀ¼���ĵ�
source : Դ��
plantform : ������ƽ̨
intel : ����cpu ��Ҫ��ԱʼǱ���PC��
arm : ���ɱ�׼

�״̬��
		����--> ��ͣ--> ֹͣ--> ����

��������ڣ�
	onCreate()  onState()  onResume()  onPause()  onStop()  onDestroy() onRestart() 

�����������ģʽ��
		standard  singleTop  singleTask  singleInstance


�������ģʽ������AndroidManifest.xml��ͨ����<activity>��ǩָ�� android:launchMode ������ѡ������ģʽ
Android �Ĵ������
		�(Activity)������(Service)���㲥������(Broadcast Receiver)�������ṩ��(Content Provider)

���л��AndroidManifest.xml�н���ע�������Ч��

Toast��Android ϵͳ�ṩ��һ�ַǳ��Ѻõ����ѷ�ʽ����ʽ���£�

		Toast.makeText(context , "��������Ϣ����" , Toast.LENGYH_SHOUT).show();

�������ʱ�ͻ�ִ��onCreate()����
protected void onCreate(Bundle saveInstanceState)

����activity �����ݣ�������Դ�ڲ���
setContentView(R.layout.cactivity_main);

��װ��������·����
build -- generated -- intermediates -- outputs -- apk -- debug -- xxx.apk 