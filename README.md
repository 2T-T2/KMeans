# KMeans
KMeans法
<br><br>
# 各フォルダ
- src <br>
KMeansのソースコード
- out <br>
ソースコードからkotlincを用いて作成したjarファイル
- sample-java <br>
javaからjarファイルを使用する方法
- sample-kotlin <br>
kotlinからjarファイルを使用する方法
<br><br>
# 注意点
各クラスターの距離の計算を「 1-相関係数 」としているので、予期しないクラスタリングの結果になることがある。
<br><br>
例：<br>
|     |     | 
| --- | --- | 
| 1.0 | 2.0 | 
| 4.0 | 5.0 | 
| 5.0 | 4.0 | 
| 2.0 | 1.0 | 
<br>
↓
<br>
cluster1 = {1.0, 2.0}, {4.0, 5.0}<br>
cluster2 = {5.0, 4.0}, {2.0, 4.0}<br>

