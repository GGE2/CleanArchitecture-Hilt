# CleanArchitecture-Hilt
CleanArchitecture , Hilt 공부


### Hilt
- SingletonComponent
    - For Application
- ActivityRetainedComponent
    - ViewModel
- ActivityComponent , AndroidEntryPoint
    - Activity
- FragmentComponent
    - Fragment
- ViewComponent
    - View
- ViewWithFragmentComponent
    - View annotated with @WithFragmentBindings
- ServiceComponent
    - Service


### Recyclerview
- 기존 notifydatetchanged()는 아이템 하나만 바뀌어도 리스트 전체를 바꾸기 때문에 굉장히 비효율적이다.
- DIffUtil은 이전데이터와 현재 데이터의 상태 차이를 계산하고 최소한의 비용으로 데이터를 갱신해준다
- 두 데이터간 차이 계산에는 Eugene W.Myners 의 Diff Algorithm 이 사용됐다고 한다.
```kotlin
private val callback =object: DiffUtil.ItemCallback<Article>(){
override funareItemsTheSame(oldItem: Article, newItem: Article): Boolean {
return oldItem.url == newItem.url
    }

override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
return oldItem == newItem
    }
}
val differ = AsyncListDiffer(this,callback)

override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

```
