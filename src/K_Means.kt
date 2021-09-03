import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

class K_Means {
    val data: Array<Array<Float>>;
    val r: Random;
    constructor(data: Array<Array<Float>>) {
        this.data = data;
        this.r = Random();
    }
    public fun fit(clusterNum: Int): Array<String> {
        val indexs = (Array(data.size){it}).toMutableList(); Collections.shuffle(indexs);

        var clusterCenter = Array(clusterNum){i->{ data[indexs[i]]; }()};
        var distances = calcDistances( clusterCenter );
        var clusters = doClustering( distances );
        var pre_distances = distances.map{ it.toPair() }.toMap();

        while( true ) {
            clusterCenter = calcClusterCenter(clusters)
            distances = calcDistances( clusterCenter )
            clusters = doClustering(distances)
            if( pre_distances.equals( distances ) ) { break; }
            else { pre_distances = distances.map{ it.toPair() }.toMap(); }
        }

        return Array(data.size) { i -> {
            var cluster = "";
            for( (k, v) in clusters ) {
                for( vv in v ) {
                    if ( data[i].equals(vv) ) {
                        cluster = k;
                        break;
                    }
                }
            }
            cluster;
        }() }
    }
    private fun calcClusterCenter( clusters: MutableMap<String, ArrayList<Array<Float>>> ): Array<Array<Float>> {
        val clustersCenter = Array(clusters.size){ i->{
            Array(data[i].size) { 0.0f }
        }()};

        for( i in 0..clusters.size-1 ) {
            for( one in clusters["cluster"+i] as ArrayList<Array<Float>> ) {
                for( j in 0..one.size-1 ) {
                    clustersCenter[i][j] = clustersCenter[i][j] + one[j];
                }
            }
            for( j in 0..clustersCenter[i].size-1 ) {
                clustersCenter[i][j] = clustersCenter[i][j] / (clusters["cluster"+i] as ArrayList<Array<Float>>).size;
            }
        }

        return clustersCenter;
    }
    private fun doClustering( distances: MutableMap<String, ArrayList<Float>> ): MutableMap<String, ArrayList<Array<Float>>> {
        val clusters = mutableMapOf<String, ArrayList<Array<Float>>>();
        for (i in 0..distances.size-1) { clusters["cluster"+i] = arrayListOf(); }

        val v_num = distances["cluster0"]?.size as Int;
        for(i in 0..v_num-1) {
            var minCluster = ""
            var minDistance = 10.0f
            for( (k,v) in distances ) {
                if( minDistance > v[i] ) {
                    minCluster = k;
                    minDistance = v[i];
                }
            }
            clusters[minCluster]?.add( data[i] )
        }
        return clusters;
    }
    private fun calcDistances(center: Array<Array<Float>>): MutableMap<String, ArrayList<Float>> {
        val clusterNum = center.size;
        val distances = mutableMapOf<String, ArrayList<Float>>();
        for (i in 0..clusterNum-1) { distances["cluster"+i] = arrayListOf(); }
        for (i in 0..clusterNum-1) { for (j in 0..data.size-1) distances["cluster"+i]?.add( 1.0f-calcCoff(center[i], data[j]) ); }
        return distances;
    }
    private fun calcCoff(x: Array<Float>, y: Array<Float>): Float {
        val calcSD = ({ data: Array<Float> -> // 標準偏差
            val ave = data.sum() / data.size;
            Math.sqrt( ((data.map { i-> (i - ave)*(i - ave) }).sum() / data.size).toDouble() ).toFloat();
        })
        val calcCov = ({ -> // 共分散
            val aveX = x.sum() / x.size;
            val aveY = y.sum() / y.size;
            ((0..x.size-1).map { i -> (x[i]-aveX)*(y[i]-aveY) }).sum() / x.size
        })
        val coff = calcCov() / ( calcSD(x) * calcSD(y) );
        return if( coff.isNaN() ) {
            0.0f
        }else{
            coff
        }
    }
}
