package com.example

import android.os.Bundle
import androidx.compose.ui.graphics.graphicsLayer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.composed
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalCafe
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.BreakfastDining
import androidx.compose.material.icons.rounded.Coffee
import androidx.compose.material.icons.rounded.Cookie
import androidx.compose.material.icons.rounded.Icecream
import androidx.compose.material.icons.rounded.LocalCafe
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material.icons.automirrored.outlined.ReceiptLong
import androidx.compose.material.icons.outlined.LocalPolice
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.LocalMall
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.animation.core.RepeatMode
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.LocalFlorist
import androidx.compose.material.icons.outlined.Widgets
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.material.icons.outlined.FilterBAndW
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.material.icons.outlined.Eco
import androidx.compose.material.icons.outlined.LocalFireDepartment
import androidx.compose.material.icons.outlined.VerifiedUser
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.ui.graphics.graphicsLayer
import coil.compose.AsyncImage
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.CaramelBrown
import com.example.ui.theme.CreamBackground
import com.example.ui.theme.DarkCoffeeBrown
import com.example.ui.theme.LightBeige
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.StarGold
import com.example.ui.theme.TextDarkGrid
import com.example.ui.theme.TextLightGrey
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    validateProductDescriptions()
    enableEdgeToEdge()
    setContent { MyApplicationTheme { CoffeeApp() } }
  }
}

@Composable
fun AurumLogo(modifier: Modifier = Modifier, size: androidx.compose.ui.unit.Dp = 48.dp, monogramColor: Color = Color(0xFFD4AF37)) {
    Image(
        painter = painterResource(id = R.drawable.aurum_logo),
        contentDescription = "Aurum Cafe Logo",
        modifier = modifier
            .size(size)
            .graphicsLayer {
                shadowElevation = 8f
            },
        contentScale = ContentScale.Fit
    )
}

@Composable
fun SplashScreen(onAnimationFinish: () -> Unit) {
    val alpha = remember { androidx.compose.animation.core.Animatable(0f) }
    
    LaunchedEffect(Unit) {
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000)
        )
        delay(1500)
        onAnimationFinish()
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(androidx.compose.ui.graphics.Brush.verticalGradient(
                colors = listOf(Color(0xFF2E221D), Color(0xFF140F0C)) // Premium dark coffee gradient
            )),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
             AurumLogo(
                 size = 60.dp,
                 modifier = Modifier.alpha(alpha.value)
             )
             Spacer(modifier = Modifier.height(24.dp))
             Text(
                 text = "AURUM CAFE",
                 fontSize = 28.sp,
                 fontWeight = FontWeight.Bold,
                 color = Color(0xFFD4AF37),
                 letterSpacing = 6.sp,
                 fontFamily = FontFamily.Serif,
                 modifier = Modifier.alpha(alpha.value)
             )
             Spacer(modifier = Modifier.height(8.dp))
             Text(
                 text = "PREMIUM CRAFTED COFFEE",
                 fontSize = 10.sp,
                 fontWeight = FontWeight.Medium,
                 color = Color(0xFFD4AF37).copy(alpha = 0.7f),
                 letterSpacing = 4.sp,
                 modifier = Modifier.alpha(alpha.value)
             )
        }
    }
}

@Composable
fun CoffeeApp() {
  val navController = rememberNavController()
  val cartItems = remember { androidx.compose.runtime.mutableStateListOf<CartItem>() }
  val wishlistItems = remember { androidx.compose.runtime.mutableStateListOf<Product>() }
  val ordersHistory = remember { androidx.compose.runtime.mutableStateListOf<Order>().apply { addAll(sampleOrders) } }
  
  var showSplash by remember { mutableStateOf(true) }
  var currentRoute by remember { mutableStateOf("home") }
  
  var userName by remember { mutableStateOf("Jane Doe") }
  var userPhone by remember { mutableStateOf("+1 555 123 4567") }
  var userPoints by remember { mutableStateOf(0) }
  var isVegOnly by remember { mutableStateOf(false) }
  val paymentMethods = remember { androidx.compose.runtime.mutableStateListOf<PaymentMethod>(
      CardPayment("1", "4111 1111 1111 1234", "12/26", true)
  ) }

  LaunchedEffect(navController) {
    navController.currentBackStackEntryFlow.collect { backStackEntry ->
      currentRoute = backStackEntry.destination.route ?: "home"
    }
  }

  if (showSplash) {
      SplashScreen(onAnimationFinish = { showSplash = false })
      return
  }

  Scaffold(
    containerColor = CreamBackground,
    bottomBar = { 
      if (currentRoute in listOf("home", "catalog", "wishlist", "account")) {
        CustomBottomNavBar(
            currentRoute = currentRoute,
            onNavigate = { route -> 
                if (route != currentRoute) {
                    if (route == "home") {
                        val popped = navController.popBackStack("home", false)
                        if (!popped) {
                            navController.navigate("home") {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                        }
                    } else {
                        navController.navigate(route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            }
        )
      }
    }
  ) { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
      NavHost(
        navController = navController, 
        startDestination = "home",
        enterTransition = { 
           androidx.compose.animation.slideInHorizontally(initialOffsetX = { 300 }, animationSpec = tween(400, easing = androidx.compose.animation.core.FastOutSlowInEasing)) + fadeIn(animationSpec = tween(400)) 
        },
        exitTransition = { 
           androidx.compose.animation.slideOutHorizontally(targetOffsetX = { -300 }, animationSpec = tween(400, easing = androidx.compose.animation.core.FastOutSlowInEasing)) + fadeOut(animationSpec = tween(400))
        },
        popEnterTransition = { 
           androidx.compose.animation.slideInHorizontally(initialOffsetX = { -300 }, animationSpec = tween(400, easing = androidx.compose.animation.core.FastOutSlowInEasing)) + fadeIn(animationSpec = tween(400)) 
        },
        popExitTransition = { 
           androidx.compose.animation.slideOutHorizontally(targetOffsetX = { 300 }, animationSpec = tween(400, easing = androidx.compose.animation.core.FastOutSlowInEasing)) + fadeOut(animationSpec = tween(400))
        }
      ) {
        composable("home") {
          CoffeeHomeScreen(
            isVegOnly = isVegOnly,
            wishlistItems = wishlistItems,
            onToggleWishlist = { product ->
               if (wishlistItems.contains(product)) wishlistItems.remove(product) 
               else wishlistItems.add(product)
            },
            onAddToCart = { product ->
               val existing = cartItems.find { it.product.id == product.id && it.size == "Standard" }
               if (existing != null) {
                  existing.quantity += 1
               } else {
                  cartItems.add(CartItem(product = product, size = "Standard", price = product.price.replace("₹", "").trim().toIntOrNull() ?: 99, quantity = 1))
               }
            },
            onOrderHistoryClick = { navController.navigate("orders") },
            onExploreMenuClick = { navController.navigate("catalog") },
            onProductClick = { id -> 
               val route = if (id.startsWith("s")) "special_product/$id" else "product/$id"
               navController.navigate(route) 
            },
            cartCount = cartItems.sumOf { it.quantity },
            onCartClick = { navController.navigate("cart") }
          )
        }
        composable("special") {
          AurumSpecialScreen(
            specialItems = specialProducts,
            onProductClick = { id -> navController.navigate("special_product/$id") },
            cartCount = cartItems.sumOf { it.quantity },
            onCartClick = { navController.navigate("cart") },
            onBackClick = { navController.popBackStack() }
          )
        }
        composable(
          "special_product/{productId}",
          arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
          val productId = backStackEntry.arguments?.getString("productId") ?: "s1"
          val product = specialProducts.find { it.id == productId } ?: specialProducts[0]
          ProductDetailScreen(
            product = product,
            wishlistItems = wishlistItems,
            onToggleWishlist = { 
               if (wishlistItems.contains(product)) wishlistItems.remove(product) 
               else wishlistItems.add(product)
            },
            onBackClick = { navController.popBackStack() },
            onProceedToCheckout = { item ->
              val existing = cartItems.find { it.product.id == item.product.id && it.size == item.size && it.extras == item.extras }
              if (existing != null) {
                 existing.quantity += item.quantity
              } else {
                 cartItems.add(item)
              }
              navController.navigate("cart")
            }
          )
        }
        composable("catalog") {
          CatalogScreen(
            isVegOnly = isVegOnly,
            wishlistItems = wishlistItems,
            onToggleWishlist = { product ->
               if (wishlistItems.contains(product)) wishlistItems.remove(product) 
               else wishlistItems.add(product)
            },
            onAddToCart = { item -> 
              val existing = cartItems.find { it.product.id == item.product.id && it.size == item.size && it.extras == item.extras }
              if (existing != null) {
                 existing.quantity += item.quantity
              } else {
                 cartItems.add(item)
              }
            },
            cartCount = cartItems.sumOf { it.quantity },
            onCartClick = { navController.navigate("cart") },
            onProductClick = { id -> 
               val route = if (id.startsWith("s")) "special_product/$id" else "product/$id"
               navController.navigate(route) 
            },
            onBackClick = {
                val popped = navController.popBackStack("home", false)
                if (!popped) {
                    navController.navigate("home")
                }
            }
          )
        }
        composable("wishlist") {
          WishlistScreen(
            wishlistItems = wishlistItems,
            onToggleWishlist = { product ->
               if (wishlistItems.contains(product)) wishlistItems.remove(product) 
               else wishlistItems.add(product)
            },
            onProductClick = { id -> 
               val route = if (id.startsWith("s")) "special_product/$id" else "product/$id"
               navController.navigate(route) 
            },
            onBackClick = { navController.popBackStack() },
            onAddToCart = { product ->
               val existing = cartItems.find { it.product.id == product.id && it.size == "Standard" }
               if (existing != null) {
                  existing.quantity += 1
               } else {
                  cartItems.add(CartItem(product = product, size = "Standard", price = product.price.replace("₹", "").trim().toIntOrNull() ?: 99, quantity = 1))
               }
            },
            cartCount = cartItems.sumOf { it.quantity },
            onCartClick = { navController.navigate("cart") }
          )
        }
        composable("orders") {
          OrderHistoryScreen(
            orders = ordersHistory,
            onBackClick = { navController.popBackStack() }
          )
        }
        composable("account") {
          ProfileScreen(
            userName = userName,
            onNameChange = { userName = it },
            userPhone = userPhone,
            onPhoneChange = { userPhone = it },
            userPoints = userPoints,
            isVegOnly = isVegOnly,
            onVegToggle = { isVegOnly = it },
            ordersCount = ordersHistory.size,
            wishlistCount = wishlistItems.size,
            paymentMethods = paymentMethods,
            onAddPaymentMethod = { paymentMethods.add(it) },
            onUpdatePaymentMethod = { old, new -> 
                val index = paymentMethods.indexOf(old)
                if (index != -1) paymentMethods[index] = new
            },
            onBackClick = { navController.popBackStack() }
          )
        }
        composable(
          "product/{productId}",
          arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
          val productId = backStackEntry.arguments?.getString("productId") ?: "1"
          val product = sampleProducts.find { it.id == productId } ?: sampleProducts[0]
          ProductDetailScreen(
            product = product,
            wishlistItems = wishlistItems,
            onToggleWishlist = { 
               if (wishlistItems.contains(product)) wishlistItems.remove(product) 
               else wishlistItems.add(product)
            },
            onBackClick = { navController.popBackStack() },
            onProceedToCheckout = { item ->
              val existing = cartItems.find { it.product.id == item.product.id && it.size == item.size && it.extras == item.extras }
              if (existing != null) {
                 existing.quantity += item.quantity
              } else {
                 cartItems.add(item)
              }
              navController.navigate("cart")
            }
          )
        }
        composable("cart") {
          CartScreen(
            cartItems = cartItems,
            onBackClick = { navController.popBackStack() },
            onCheckout = { navController.navigate("payment") },
            onRemoveItem = { item -> cartItems.remove(item) },
            onUpdateQuantity = { item, newQty ->
              val index = cartItems.indexOf(item)
              if (index != -1) cartItems[index] = cartItems[index].copy(quantity = newQty)
            },
            onClearCart = { cartItems.clear() }
          )
        }
        composable("payment") {
          val subtotal = cartItems.sumOf { it.price * it.quantity }
          val gst = (subtotal * 0.05).toInt()
          val convenienceFee = 20
          val grandTotal = subtotal + gst + convenienceFee
          PaymentScreen(
            cartItems = cartItems,
            totalAmount = grandTotal,
            savedMethods = paymentMethods,
            onBackClick = { navController.popBackStack() },
            onPaymentSuccess = { 
              val newOrder = Order(
                id = "ORD-${(1000..9999).random()}",
                date = java.text.SimpleDateFormat("dd MMM yyyy", java.util.Locale.getDefault()).format(java.util.Date()),
                status = "Processing",
                items = cartItems.toList(),
                total = grandTotal
              )
              ordersHistory.add(0, newOrder)
              userPoints += (grandTotal * 0.1).toInt()
              cartItems.clear()
              navController.navigate("orders") {
                popUpTo("home") { inclusive = false }
              }
            }
          )
        }
      }
    }
  }
}


sealed class PaymentMethod {
    abstract val id: String
    abstract val isPrimary: Boolean
}
data class CardPayment(override val id: String, val cardNumber: String, val expiry: String, override val isPrimary: Boolean = false) : PaymentMethod()
data class UpiPayment(override val id: String, val upiId: String, override val isPrimary: Boolean = false) : PaymentMethod()
data class NetBankingPayment(override val id: String, val bankName: String, override val isPrimary: Boolean = false) : PaymentMethod()
data class WalletPayment(override val id: String, val walletName: String, val phoneNumber: String, override val isPrimary: Boolean = false) : PaymentMethod()

@Composable
fun ProfileScreen(
    userName: String,
    onNameChange: (String) -> Unit,
    userPhone: String,
    onPhoneChange: (String) -> Unit,
    userPoints: Int,
    isVegOnly: Boolean,
    onVegToggle: (Boolean) -> Unit,
    ordersCount: Int,
    wishlistCount: Int,
    paymentMethods: List<PaymentMethod>,
    onAddPaymentMethod: (PaymentMethod) -> Unit,
    onUpdatePaymentMethod: (PaymentMethod, PaymentMethod) -> Unit,
    onBackClick: () -> Unit
) {
    var isEditing by remember { mutableStateOf(false) }
    var showPaymentDialog by remember { mutableStateOf(false) }
    var editingPaymentMethod by remember { mutableStateOf<PaymentMethod?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E130C))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .border(1.dp, Color.White.copy(alpha = 0.2f), CircleShape)
                        .clip(CircleShape)
                        .clickable { onBackClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text("My Profile", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text("Manage your details & preferences", fontSize = 12.sp, color = Color.LightGray)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFF9F6F0)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Filled.Person, contentDescription = "Profile", modifier = Modifier.size(48.dp), tint = DarkCoffeeBrown)
                    }
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(userName, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Spacer(modifier = Modifier.width(12.dp))
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0x33E5A152))
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Filled.Star, contentDescription = null, tint = Color(0xFFE5A152), modifier = Modifier.size(12.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            val isGold = ordersCount >= 5
                            val tierName = if (isGold) "Gold Member" else if (ordersCount >= 2) "Silver Member" else "Bronze Member"
                            val tierColor = if (isGold) Color(0xFFE5A152) else if (ordersCount >= 2) Color.LightGray else Color(0xFFCD7F32)
                            Text(tierName, color = tierColor, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("animecult143@gmail.com", fontSize = 14.sp, color = Color.LightGray)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(userPhone, fontSize = 14.sp, color = Color.LightGray)
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(CreamBackground)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(vertical = 20.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StatItem(Icons.Filled.Star, "$userPoints", "Reward Points", Color(0xFFE5A152))
                    Box(modifier = Modifier.width(1.dp).height(40.dp).background(Color.LightGray.copy(alpha = 0.5f)))
                    StatItem(Icons.Filled.Coffee, "$ordersCount", "Orders", CaramelBrown)
                    Box(modifier = Modifier.width(1.dp).height(40.dp).background(Color.LightGray.copy(alpha = 0.5f)))
                    StatItem(Icons.Filled.LocalOffer, "3", "Offers", CaramelBrown)
                    Box(modifier = Modifier.width(1.dp).height(40.dp).background(Color.LightGray.copy(alpha = 0.5f)))
                    StatItem(Icons.Filled.FavoriteBorder, "$wishlistCount", "Wishlist", CaramelBrown)
                }

                Column(modifier = Modifier.padding(16.dp)) {
                    ProfileSectionCard(
                        title = "Personal Information",
                        icon = Icons.Filled.Person,
                        actionText = if (isEditing) "Done" else "Edit",
                        actionIcon = if (isEditing) Icons.Filled.CheckCircle else Icons.Filled.Edit,
                        onActionClick = { isEditing = !isEditing }
                    ) {
                        if (isEditing) {
                            OutlinedTextField(
                                value = userName,
                                onValueChange = onNameChange,
                                label = { Text("Display Name") },
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown, focusedLabelColor = DarkCoffeeBrown)
                            )
                            OutlinedTextField(
                                value = userPhone,
                                onValueChange = onPhoneChange,
                                label = { Text("Phone Number") },
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown, focusedLabelColor = DarkCoffeeBrown)
                            )
                        } else {
                            ProfileDetailItem("Display Name", userName, Icons.Filled.Person)
                            Box(modifier = Modifier.fillMaxWidth().padding(start = 56.dp).height(1.dp).background(Color.LightGray.copy(alpha = 0.3f)))
                            ProfileDetailItem("Phone Number", userPhone, Icons.Filled.Phone)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    ProfileSectionCard(
                        title = "Diet Preference",
                        icon = Icons.Filled.Eco
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFF1F8E9))
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Filled.Eco, contentDescription = null, tint = Color(0xFF388E3C), modifier = Modifier.size(24.dp))
                                Spacer(modifier = Modifier.width(16.dp))
                                Column {
                                    Text("Pure Veg", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = TextDarkGrid)
                                    Text("Only vegetarian", fontSize = 12.sp, color = TextLightGrey)
                                }
                            }
                            Switch(
                                checked = isVegOnly,
                                onCheckedChange = onVegToggle,
                                colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFF689F38))
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    ProfileSectionCard(
                        title = "Payment Methods",
                        icon = Icons.Filled.CreditCard,
                        actionText = "Add New",
                        actionIcon = Icons.Filled.AddCircle,
                        onActionClick = {
                            editingPaymentMethod = null
                            showPaymentDialog = true
                        }
                    ) {
                        if (paymentMethods.isEmpty()) {
                            Text("No payment methods added.", modifier = Modifier.padding(16.dp), color = TextLightGrey)
                        } else {
                            paymentMethods.forEach { method ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            editingPaymentMethod = method
                                            showPaymentDialog = true
                                        }
                                        .padding(horizontal = 16.dp, vertical = 12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(width = 48.dp, height = 32.dp)
                                            .border(1.dp, Color.LightGray.copy(alpha=0.5f), RoundedCornerShape(4.dp))
                                            .background(Color.White, RoundedCornerShape(4.dp)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        when (method) {
                                            is CardPayment -> Text("CARD", color = Color(0xFF1A1F71), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                            is UpiPayment -> Text("UPI", color = Color(0xFFE5A152), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                            is NetBankingPayment -> Text("BANK", color = DarkCoffeeBrown, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                            is WalletPayment -> Text("WALL", color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        when (method) {
                                            is CardPayment -> {
                                                Text("•••• •••• •••• ${method.cardNumber.takeLast(4)}", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = TextDarkGrid)
                                                Text("Expires ${method.expiry}", fontSize = 14.sp, color = TextLightGrey)
                                            }
                                            is UpiPayment -> {
                                                Text(method.upiId, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = TextDarkGrid)
                                                Text("UPI", fontSize = 14.sp, color = TextLightGrey)
                                            }
                                            is NetBankingPayment -> {
                                                Text(method.bankName, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = TextDarkGrid)
                                                Text("Net Banking", fontSize = 14.sp, color = TextLightGrey)
                                            }
                                            is WalletPayment -> {
                                                Text(method.walletName, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = TextDarkGrid)
                                                Text(method.phoneNumber, fontSize = 14.sp, color = TextLightGrey)
                                            }
                                        }
                                    }
                                    if (method.isPrimary) {
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(LightBeige)
                                                .padding(horizontal = 6.dp, vertical = 2.dp)
                                        ) {
                                            Text("Primary", fontSize = 10.sp, color = DarkCoffeeBrown, fontWeight = FontWeight.Medium)
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "More options", tint = TextLightGrey)
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }

        if (showPaymentDialog) {
            var selectedType by remember { mutableStateOf(if (editingPaymentMethod is UpiPayment) "UPI" else if (editingPaymentMethod is NetBankingPayment) "BANK" else if (editingPaymentMethod is WalletPayment) "WALLET" else "CARD") }
            var tempCardNumber by remember { mutableStateOf((editingPaymentMethod as? CardPayment)?.cardNumber ?: "") }
            var tempExpiry by remember { mutableStateOf((editingPaymentMethod as? CardPayment)?.expiry ?: "") }
            var tempUpi by remember { mutableStateOf((editingPaymentMethod as? UpiPayment)?.upiId ?: "") }
            var tempBank by remember { mutableStateOf((editingPaymentMethod as? NetBankingPayment)?.bankName ?: "") }
            var tempWalletName by remember { mutableStateOf((editingPaymentMethod as? WalletPayment)?.walletName ?: "") }
            var tempPhoneNumber by remember { mutableStateOf((editingPaymentMethod as? WalletPayment)?.phoneNumber ?: "") }
            var tempPrimary by remember { mutableStateOf(editingPaymentMethod?.isPrimary ?: false) }
    
            androidx.compose.material3.AlertDialog(
                onDismissRequest = { showPaymentDialog = false },
                title = { Text(if (editingPaymentMethod != null) "Edit Payment Method" else "Add Payment Method") },
                containerColor = Color.White,
                text = {
                    Column {
                        Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(onClick = { selectedType = "CARD" }, colors = ButtonDefaults.buttonColors(containerColor = if (selectedType == "CARD") DarkCoffeeBrown else Color.LightGray)) { Text("Card") }
                            Button(onClick = { selectedType = "UPI" }, colors = ButtonDefaults.buttonColors(containerColor = if (selectedType == "UPI") DarkCoffeeBrown else Color.LightGray)) { Text("UPI") }
                            Button(onClick = { selectedType = "BANK" }, colors = ButtonDefaults.buttonColors(containerColor = if (selectedType == "BANK") DarkCoffeeBrown else Color.LightGray)) { Text("Bank") }
                            Button(onClick = { selectedType = "WALLET" }, colors = ButtonDefaults.buttonColors(containerColor = if (selectedType == "WALLET") DarkCoffeeBrown else Color.LightGray)) { Text("Wallet") }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        if (selectedType == "CARD") {
                            OutlinedTextField(value = tempCardNumber, onValueChange = { tempCardNumber = it }, label = { Text("Card Number") }, colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown))
                            OutlinedTextField(value = tempExpiry, onValueChange = { tempExpiry = it }, label = { Text("Expiry (MM/YY)") }, colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown))
                        } else if (selectedType == "UPI") {
                            OutlinedTextField(value = tempUpi, onValueChange = { tempUpi = it }, label = { Text("UPI ID") }, colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown))
                        } else if (selectedType == "BANK") {
                            OutlinedTextField(value = tempBank, onValueChange = { tempBank = it }, label = { Text("Bank Name") }, colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown))
                        } else if (selectedType == "WALLET") {
                            OutlinedTextField(value = tempWalletName, onValueChange = { tempWalletName = it }, label = { Text("Wallet Name") }, colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown))
                            OutlinedTextField(value = tempPhoneNumber, onValueChange = { tempPhoneNumber = it }, label = { Text("Phone Number") }, colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 8.dp)) {
                            androidx.compose.material3.Checkbox(checked = tempPrimary, onCheckedChange = { tempPrimary = it }, colors = androidx.compose.material3.CheckboxDefaults.colors(checkedColor = DarkCoffeeBrown))
                            Text("Set as Primary", color = TextDarkGrid)
                        }
                    }
                },
                confirmButton = {
                    Button(onClick = {
                        val newMethod = when (selectedType) {
                            "CARD" -> CardPayment(editingPaymentMethod?.id ?: java.util.UUID.randomUUID().toString(), tempCardNumber.ifEmpty { "XXXX" }, tempExpiry.ifEmpty { "12/99" }, tempPrimary)
                            "UPI" -> UpiPayment(editingPaymentMethod?.id ?: java.util.UUID.randomUUID().toString(), tempUpi.ifEmpty { "user@upi" }, tempPrimary)
                            "WALLET" -> WalletPayment(editingPaymentMethod?.id ?: java.util.UUID.randomUUID().toString(), tempWalletName.ifEmpty { "My Wallet" }, tempPhoneNumber.ifEmpty { "9999999999" }, tempPrimary)
                            else -> NetBankingPayment(editingPaymentMethod?.id ?: java.util.UUID.randomUUID().toString(), tempBank.ifEmpty { "My Bank" }, tempPrimary)
                        }
                        if (editingPaymentMethod != null) {
                            onUpdatePaymentMethod(editingPaymentMethod!!, newMethod)
                        } else {
                            onAddPaymentMethod(newMethod)
                        }
                        showPaymentDialog = false
                    }, colors = ButtonDefaults.buttonColors(containerColor = DarkCoffeeBrown)) {
                        Text("Save")
                    }
                },
                dismissButton = {
                    androidx.compose.material3.TextButton(onClick = { showPaymentDialog = false }) { Text("Cancel", color = DarkCoffeeBrown) }
                }
            )
        }
    }
}

@Composable
fun StatItem(icon: ImageVector, value: String, label: String, iconColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text(value, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, fontSize = 12.sp, color = TextLightGrey)
    }
}

@Composable
fun ProfileSectionCard(
    title: String, 
    icon: ImageVector,
    actionText: String? = null,
    actionIcon: ImageVector? = null,
    onActionClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(32.dp).background(DarkCoffeeBrown, RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center) {
                        Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
                }
                if (actionText != null && actionIcon != null) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically, 
                        modifier = Modifier.clickable { onActionClick() }
                    ) {
                        Text(actionText, fontSize = 12.sp, color = DarkCoffeeBrown, fontWeight = FontWeight.Medium)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(actionIcon, contentDescription = null, tint = DarkCoffeeBrown, modifier = Modifier.size(14.dp))
                    }
                }
            }
            content()
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ProfileDetailItem(label: String, value: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(LightBeige, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = null, tint = DarkCoffeeBrown, modifier = Modifier.size(16.dp))
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(label, fontSize = 12.sp, color = TextLightGrey)
            Text(value, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = TextDarkGrid)
        }
        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, tint = TextLightGrey, modifier = Modifier.size(18.dp))
    }
}

@Composable
fun PlaceholderScreen(title: String, onBack: () -> Unit) {
  Column(modifier = Modifier.fillMaxSize().background(CreamBackground)) {
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
      Box(modifier = Modifier.size(44.dp).shadow(4.dp, CircleShape).clip(CircleShape).background(Color.White).clickable { onBack() }, contentAlignment = Alignment.Center) {
        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = DarkCoffeeBrown)
      }
      Spacer(modifier = Modifier.width(16.dp))
      Text(title, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      Text("$title Screen under construction.", color = TextLightGrey)
    }
  }
}

@Composable
fun SignatureCarouselSection(
    onProductClick: (String) -> Unit = {},
    onAddToCart: (Product) -> Unit = {}
) {
    val haptic = androidx.compose.ui.platform.LocalHapticFeedback.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "PREMIUM SELECTIONS",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = CaramelBrown,
                    letterSpacing = 2.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    "Exclusive Signatures",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkCoffeeBrown,
                    fontFamily = FontFamily.Serif
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFD4AF37).copy(alpha = 0.12f))
                    .border(1.dp, Color(0xFFD4AF37).copy(alpha = 0.3f), RoundedCornerShape(12.dp))
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "LTD EDITION",
                    fontSize = 9.sp,
                    color = Color(0xFFA66A35),
                    fontWeight = FontWeight.Black,
                    letterSpacing = 1.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            specialProducts.forEach { product ->
                Column(
                    modifier = Modifier
                        .width(180.dp)
                        .graphicsLayer {
                            shadowElevation = 6f
                            shape = RoundedCornerShape(20.dp)
                            clip = true
                        }
                        .background(Color.White)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFD4AF37).copy(alpha = 0.2f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { onProductClick(product.id) }
                        .padding(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .clip(RoundedCornerShape(14.dp))
                    ) {
                        AsyncImage(
                            model = product.imageRes,
                            contentDescription = product.name,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        // Floating Gold Badge
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(6.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFD4AF37))
                                .padding(horizontal = 6.dp, vertical = 3.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(10.dp)
                                )
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(
                                    text = product.rating,
                                    color = Color.White,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = product.name,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkCoffeeBrown,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = product.subtitle,
                        fontSize = 10.sp,
                        color = TextLightGrey,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = product.price,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black,
                            color = CaramelBrown
                        )

                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFD4AF37))
                                .clickable {
                                    onAddToCart(product)
                                    haptic.performHapticFeedback(androidx.compose.ui.hapticfeedback.HapticFeedbackType.LongPress)
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Add",
                                tint = Color.White,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CoffeeHomeScreen(isVegOnly: Boolean = false, wishlistItems: List<Product>, onToggleWishlist: (Product) -> Unit, onAddToCart: (Product) -> Unit = {}, onOrderHistoryClick: () -> Unit = {}, onExploreMenuClick: () -> Unit = {}, onProductClick: (String) -> Unit = {}, cartCount: Int = 0, onCartClick: () -> Unit = {}) {
  var isVisible by remember { mutableStateOf(false) }
  var showFilters by remember { mutableStateOf(false) }
  var searchQuery by remember { mutableStateOf("") }
  var selectedCategory by remember { mutableStateOf("All") }
  var selectedRoast by remember { mutableStateOf("All") }

  val filteredProducts = remember(searchQuery, selectedCategory, selectedRoast, isVegOnly) {
     sampleProducts.filter { 
         (searchQuery.isEmpty() || it.name.contains(searchQuery, ignoreCase = true)) &&
         (selectedCategory == "All" || it.category == selectedCategory) &&
         (selectedRoast == "All" || (it.roastProfile ?: "All") == selectedRoast) &&
         (!isVegOnly || it.isVeg)
     }
  }

  LaunchedEffect(Unit) {
    isVisible = true
  }

  val scrollState = rememberScrollState()

  Box(modifier = Modifier.fillMaxSize().background(CreamBackground)) {
    LazyColumn(
      modifier = Modifier.fillMaxSize()
    ) {
       item {
           Box(modifier = Modifier.fillMaxWidth().height(480.dp).background(Color.Black)) {
              HeroBanner(onExploreClick = onExploreMenuClick)
              SharedTopBar(
                  cartCount = cartCount, 
                  onCartClick = onCartClick, 
                  onMenuClick = onOrderHistoryClick
              )
           }
       }
       
       item {
           Column(
             modifier = Modifier
               .fillMaxWidth()
               .offset(y = (-32).dp)
               .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
               .background(CreamBackground)
               .padding(top = 24.dp)
           ) {
               // Welcome & Elegant Text Header
               Column(
                 modifier = Modifier
                   .fillMaxWidth()
                   .padding(horizontal = 16.dp, vertical = 6.dp)
               ) {
                 Text(
                   "WELCOME TO AURUM", 
                   fontSize = 11.sp, 
                   fontWeight = FontWeight.Bold, 
                   color = CaramelBrown,
                   letterSpacing = 2.sp
                 )
                 Spacer(modifier = Modifier.height(2.dp))
                 Text(
                   "Select Your Pure Craft", 
                   fontSize = 24.sp, 
                   fontWeight = FontWeight.Bold, 
                   color = DarkCoffeeBrown,
                   fontFamily = FontFamily.Serif
                 )
               }

               Spacer(modifier = Modifier.height(12.dp))

               Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                   SearchSection(
                       searchQuery = searchQuery, 
                       onQueryChange = { searchQuery = it },
                       onFilterClick = { showFilters = true }
                   )
               }
               Spacer(modifier = Modifier.height(20.dp))
               
               CategorySection(selectedCategory = selectedCategory, onCategorySelect = { selectedCategory = it }) 
               
               Spacer(modifier = Modifier.height(14.dp))
               SignatureCarouselSection(onProductClick = onProductClick, onAddToCart = onAddToCart)
               Spacer(modifier = Modifier.height(32.dp))
           }
       }
            
       // Modern Empty State Fallback or Staggered Product Grid
       if (filteredProducts.isEmpty()) {
           item {
               Column(
                 modifier = Modifier
                   .fillMaxWidth()
                   .offset(y = (-32).dp)
                   .background(CreamBackground)
                   .padding(vertical = 48.dp, horizontal = 24.dp),
                 horizontalAlignment = Alignment.CenterHorizontally,
                 verticalArrangement = Arrangement.Center
               ) {
                 Icon(
                   imageVector = Icons.Rounded.Coffee, 
                   contentDescription = "Empty", 
                   tint = CaramelBrown.copy(alpha = 0.5f), 
                   modifier = Modifier.size(64.dp)
                 )
                 Spacer(modifier = Modifier.height(16.dp))
                 Text(
                   text = "No Delicacies Found", 
                   fontSize = 16.sp, 
                   fontWeight = FontWeight.Bold, 
                   color = DarkCoffeeBrown,
                   fontFamily = FontFamily.Serif
                 )
                 Spacer(modifier = Modifier.height(6.dp))
                 Text(
                   text = "Try searching for another item or adjust your criteria.", 
                   fontSize = 12.sp, 
                   color = TextLightGrey,
                   textAlign = TextAlign.Center
                 )
               }
           }
       } else {
           val itemsPair = filteredProducts.chunked(2)
           items(itemsPair.size) { rowIndex ->
              val rowItems = itemsPair[rowIndex]
              Row(modifier = Modifier.fillMaxWidth().offset(y = (-32).dp).background(CreamBackground).padding(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                 for (product in rowItems) {
                    Box(modifier = Modifier.weight(1f)) {
                       AnimatedProductCard(
                         product = product, 
                         index = rowIndex * 2 + rowItems.indexOf(product), 
                         isVisible = isVisible, 
                         isFavorite = wishlistItems.contains(product),
                         onToggleFavorite = { onToggleWishlist(product) },
                         onClick = { onProductClick(product.id) },
                         onAddToCart = { onAddToCart(product) }
                       )
                    }
                 }
                 if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                 }
              }
              Spacer(modifier = Modifier.height(16.dp).fillMaxWidth().offset(y = (-32).dp).background(CreamBackground))
           }
           item {
              Spacer(modifier = Modifier.height(100.dp).fillMaxWidth().offset(y = (-32).dp).background(CreamBackground))
           }
       }
    }
  }

  if (showFilters) {
      val roastProfiles = listOf("All", "Light Roast", "Medium Roast", "Dark Roast")
      @OptIn(ExperimentalMaterial3Api::class)
      ModalBottomSheet(
          onDismissRequest = { showFilters = false },
          containerColor = LightBeige
      ) {
          Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 32.dp)) {
              Text("Filters", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
              Spacer(modifier = Modifier.height(16.dp))
              
              Text("Categories", fontWeight = FontWeight.Bold, color = TextDarkGrid, fontSize = 14.sp)
              Spacer(modifier = Modifier.height(8.dp))
              Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                  categories.forEach { category ->
                      CustomChip(
                          text = category.title, 
                          isSelected = selectedCategory == category.title, 
                          onClick = { selectedCategory = category.title; if(category.title != "Beans") selectedRoast = "All" }
                      )
                  }
              }
              
              Spacer(modifier = Modifier.height(24.dp))
              
              AnimatedVisibility(visible = selectedCategory == "All" || selectedCategory == "Beans" || selectedCategory == "Hot Coffee" || selectedCategory == "Cold Coffee") {
                  Column {
                      Text("Roast Profile", fontWeight = FontWeight.Bold, color = TextDarkGrid, fontSize = 14.sp)
                      Spacer(modifier = Modifier.height(8.dp))
                      Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                          roastProfiles.forEach { roast ->
                              CustomChip(
                                  text = roast, 
                                  isSelected = selectedRoast == roast, 
                                  onClick = { selectedRoast = roast }
                              )
                          }
                      }
                      Spacer(modifier = Modifier.height(16.dp))
                  }
              }
              Spacer(modifier = Modifier.height(16.dp))
          }
      }
  }
}

@Composable
fun TopBar(onOrderHistoryClick: () -> Unit, cartCount: Int = 0, onCartClick: () -> Unit = {}) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(70.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    IconButton(onClick = onOrderHistoryClick) {
      Icon(Icons.Filled.Menu, contentDescription = "Order History", tint = DarkCoffeeBrown)
    }
    Text(
      text = "Coffee Store",
      color = DarkCoffeeBrown,
      fontFamily = FontFamily.Cursive, // Fallback for slightly handwritten look
      fontWeight = FontWeight.Bold,
      fontSize = 28.sp,
      letterSpacing = 1.sp
    )
    IconButton(onClick = onCartClick) {
      Box(contentAlignment = Alignment.Center) {
        Icon(Icons.Filled.ShoppingCart, contentDescription = "Cart", tint = DarkCoffeeBrown)
        if (cartCount > 0) {
          Box(
            modifier = Modifier
              .align(Alignment.TopEnd)
              .offset(x = 8.dp, y = (-4).dp)
              .size(16.dp)
              .clip(CircleShape)
              .background(CaramelBrown),
            contentAlignment = Alignment.Center
          ) {
            Text(text = cartCount.toString(), color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
          }
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSection(searchQuery: String, onQueryChange: (String) -> Unit, onFilterClick: (() -> Unit)? = null) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 10.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    TextField(
      value = searchQuery,
      onValueChange = onQueryChange,
      modifier = Modifier
        .weight(1f)
        .border(1.dp, Color(0xFF5A3214).copy(alpha = 0.15f), RoundedCornerShape(28.dp)),
      placeholder = { Text("Search our premium collection...", color = TextLightGrey) },
      leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search", tint = DarkCoffeeBrown, modifier = Modifier.size(18.dp)) },
      shape = RoundedCornerShape(28.dp),
      colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
      ),
      singleLine = true
    )
    Spacer(modifier = Modifier.width(12.dp))
    Box(
      modifier = Modifier
        .size(48.dp)
        .graphicsLayer {
          shadowElevation = 8f
          shape = CircleShape
          clip = true
        }
        .background(DarkCoffeeBrown)
        .clickable { 
          if (onFilterClick != null) onFilterClick() 
          else onQueryChange("") 
        },
      contentAlignment = Alignment.Center
    ) {
      Icon(Icons.Filled.Tune, contentDescription = "Filter", tint = Color(0xFFD4AF37), modifier = Modifier.size(20.dp))
    }
  }
}

data class Category(val title: String, val icon: ImageVector)

val categories = listOf(
  Category("All", Icons.Filled.Dashboard),
  Category("Hot Coffee", Icons.Rounded.Coffee),
  Category("Cold Coffee", Icons.Filled.LocalDrink),
  Category("Tea", Icons.Rounded.LocalCafe),
  Category("Signature", Icons.Filled.Star),
  Category("Bakery", Icons.Filled.BakeryDining),
  Category("Dessert", Icons.Filled.Cake),
  Category("Snacks", Icons.Outlined.ShoppingBag),
  Category("Refreshers", Icons.Filled.LocalDrink)
)

@Composable
fun CategorySection(selectedCategory: String, onCategorySelect: (String) -> Unit) {
  val scrollState = rememberScrollState()
  val haptic = LocalHapticFeedback.current

  Row(
    modifier = Modifier
      .fillMaxWidth()
      .horizontalScroll(scrollState)
      .padding(horizontal = 16.dp, vertical = 6.dp),
    horizontalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    categories.forEach { category ->
      val isSelected = category.title == selectedCategory

      // Smooth modern transitions
      val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.08f else 1.0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessMedium),
        label = "categoryScale"
      )

      val backgroundColor by androidx.compose.animation.animateColorAsState(
        targetValue = if (isSelected) DarkCoffeeBrown else Color.White,
        animationSpec = tween(250),
        label = "categoryBg"
      )

      val contentColor by androidx.compose.animation.animateColorAsState(
        targetValue = if (isSelected) Color(0xFFD4AF37) else TextDarkGrid,
        animationSpec = tween(250),
        label = "categoryContent"
      )

      val borderColor by androidx.compose.animation.animateColorAsState(
        targetValue = if (isSelected) Color(0xFFD4AF37) else Color.LightGray.copy(alpha = 0.25f),
        animationSpec = tween(250),
        label = "categoryBorder"
      )

      Column(
        modifier = Modifier
          .width(78.dp)
          .height(86.dp)
          .graphicsLayer {
            scaleX = scale
            scaleY = scale
            shadowElevation = if (isSelected) 12f else 2f
            shape = RoundedCornerShape(18.dp)
            clip = true
          }
          .background(backgroundColor)
          .border(1.dp, borderColor, RoundedCornerShape(18.dp))
          .clickable {
            onCategorySelect(category.title)
            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
          },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
      ) {
        Icon(
          imageVector = category.icon,
          contentDescription = category.title,
          tint = contentColor,
          modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
          text = category.title,
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = contentColor,
          maxLines = 1,
          overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
        )
      }
    }
  }
}

@Composable
fun HeroBanner(onExploreClick: () -> Unit = {}) {
  Box(modifier = Modifier.fillMaxSize()) {
    // Coil AsyncImage for memory-safe background-loading and image recycling
    AsyncImage(
      model = R.drawable.hero_coffee_banner_1781284553613,
      contentDescription = "Hero Banner",
      contentScale = ContentScale.Crop,
      modifier = Modifier.fillMaxSize()
    )
    
    // Immersive Rich Cinematic Overlay (Dark Radial to Vertical Coffee/Gold Gradient)
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(
          Brush.verticalGradient(
            colors = listOf(
              Color.Black.copy(alpha = 0.5f),
              Color.Black.copy(alpha = 0.1f),
              Color(0xFF1E130C).copy(alpha = 0.95f) // Deep warm espresso bottom fade
            )
          )
        )
    )

    Column(modifier = Modifier.fillMaxSize()) {
      Spacer(modifier = Modifier.weight(1f))
      
      // Luxury crafted bottom typography
      Column(
        modifier = Modifier
          .padding(horizontal = 24.dp)
          .padding(bottom = 75.dp)
      ) {
        Text(
          text = buildAnnotatedString {
             append("Crafted coffee,\n")
             withStyle(style = androidx.compose.ui.text.SpanStyle(color = Color(0xFFD4AF37))) { // Premium Gold Accent
                append("perfectly yours.")
             }
          },
          color = Color.White,
          fontSize = 34.sp,
          fontWeight = FontWeight.ExtraBold,
          lineHeight = 40.sp,
          fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
          text = "Artisanal handpicked beans. Micro-roasted precisely. Pure luxury in every single cup.",
          color = Color.White.copy(alpha = 0.8f),
          fontSize = 13.sp,
          lineHeight = 18.sp,
          fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
          modifier = Modifier
            .clip(RoundedCornerShape(28.dp))
            .background(
              Brush.horizontalGradient(
                colors = listOf(Color(0xFFD4AF37), Color(0xFFA66A35)) // Beautiful golden-caramel gradient pill button
              )
            )
            .clickable { onExploreClick() }
            .padding(horizontal = 24.dp, vertical = 12.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            "Explore Golden Menu", 
            color = Color.White, 
            fontSize = 14.sp, 
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text("→", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
      }
    }
  }
}

data class Product(
  val id: String,
  val name: String,
  val category: String,
  val subtitle: String,
  val rating: String,
  val price: String,
  val imageRes: Int,
  val roastProfile: String? = null,
  val isVeg: Boolean = true
)

fun getUniqueProductDescription(product: Product): String {
    val name = product.name
    val category = product.category
    val id = product.id
    
    val cuisine = when {
        category.contains("Coffee") -> "Italian Espresso Tradition"
        category.contains("Tea") -> {
            when {
                name.contains("Masala") || name.contains("Chai") -> "Traditional Indian Spice Blend"
                name.contains("Moroccan") -> "North African Herbal Custom"
                name.contains("English") -> "British Royal Breakfast Tradition"
                name.contains("Matcha") || name.contains("Jasmine") -> "East Asian Ceremonial Tradition"
                else -> "Artisanal Herbal Infusion"
            }
        }
        category.contains("Signature") -> {
            when {
                name.contains("Belgian") -> "Belgian Chocolatier Craftsmanship"
                name.contains("Turmeric") || name.contains("Saffron") -> "Ancient Ayurvedic Wellness Blend"
                else -> "Aurum Café House Reserve"
            }
        }
        category.contains("Bakery") || category.contains("Dessert") -> {
            when {
                name.contains("Croissant") || name.contains("Pain") || name.contains("Macaron") || name.contains("Danish") -> "French Patisserie"
                name.contains("Tiramisu") -> "Italian Dolci Tradition"
                name.contains("Cheesecake") -> "New York Confectionery Style"
                else -> "Artisanal Bakery Craft"
            }
        }
        category.contains("Snacks") -> {
            when {
                name.contains("Avocado") || name.contains("Mediterranean") -> "Gourmet Mediterranean-Californian Cuisine"
                name.contains("Chicken") -> "Continental Café Cuisine"
                else -> "Handcrafted Bistro Cuisine"
            }
        }
        category.contains("Refreshers") -> "Tropical Fusion Mixology"
        else -> "Gourmet Craft Culinary Style"
    }

    val prepStyle = when {
        name.contains("Espresso") -> "high-pressure extraction of house-roasted Arabica beans, pulling a golden crema"
        name.contains("Cold Brew") -> "slow, 18-hour cold water immersion steeping, filtering out acidity for ultra-smooth body"
        name.contains("Nitro") -> "slow-steeped cold brew infused with pure nitrogen gas under pressure, creating a velvety, cascading draft"
        name.contains("Iced") -> "freshly pulled espresso shaken over custom ice spheres and layered with chilled dairy"
        name.contains("Latte") || name.contains("Cappuccino") -> "skilfully pulling espresso and stretching milk to create a micro-foam with customized latte art"
        category.contains("Tea") -> {
            if (name.contains("Matcha")) "whisking stone-ground green tea leaves vigorously into steamed milk at exactly 80°C"
            else "precision steeping of single-origin loose tea leaves in pure filtered water for exactly 4 minutes"
        }
        category.contains("Bakery") || category.contains("Dessert") -> "baked from scratch daily in small batches using premium high-butter pastry sheets and aged vanilla pods"
        name.contains("Toast") || name.contains("Sandwich") || name.contains("Panini") -> "griddled to order on sourdough bread, pressed firmly to seal the internal flavors and achieve a golden crust"
        category.contains("Refreshers") -> "muddled fresh fruit pulps shaken vigorously with house-infused herbal syrups and sparkling spring water"
        else -> "meticulously curated and hand-assembled with high-grade local ingredients just before serving"
    }

    val ingredients = when {
        name.contains("Gold") || name.contains("Aurum") -> "24-Karat Edible Gold Leaf flakes, 100% Arabica bean extract, organic honey, and rich jersey cows milk"
        name.contains("Truffle") -> "Imported European black truffle shavings, double-shot espresso, organic maple syrup, and velvety oat milk"
        name.contains("Saffron") -> "Kashmiri saffron strands, cardamom pods, organic cane sugar, and high-density whipped cream"
        name.contains("Espresso") -> "pure pressurized double filter extraction of ground Arabica and Robusta legacy beans"
        name.contains("Americano") -> "two shots of masterfully pulled espresso and heated mountain spring water"
        name.contains("Cappuccino") -> "equal parts bold espresso, hot steamed milk, and a luxurious dense layer of micro-foam"
        name.contains("Latte") -> "single or double shot of rich espresso topped with sweetened, silky micro-foamed milk"
        name.contains("Mocha") || name.contains("Chocolate") -> "Premium roasted single-origin Belgian cocoa, freshly pulled espresso, and steamed milk whipped with chocolate curls"
        name.contains("Caramel") || name.contains("Macchiato") -> "house-made buttery caramel sauce, vanilla-infused milk, and a direct pour of bold espresso"
        name.contains("Hazelnut") -> "toasted hazelnut puree, cold-pressed Arabica coffee, and organic almond milk"
        name.contains("Irish") -> "classic non-alcoholic Irish malt syrup extract, brown sugar, espresso, and standard rich floating cream"
        name.contains("Tea") || name.contains("Chai") -> {
            when {
                name.contains("Earl Grey") -> "premium black tea leaves infused with natural oil of bergamot rinds"
                name.contains("Masala") -> "CTC black tea leaves, crushed green cardamom, cloves, cinnamon bark, and freshly grated ginger root"
                name.contains("Matcha") -> "ceremonial grade stone-ground Uji matcha green tea powder and soy milk"
                name.contains("Jasmine") -> "whole-leaf green tea scented delicately with fresh night-blooming jasmine blossoms"
                else -> "premium select loose tea leaves and purified hot water"
            }
        }
        name.contains("Croissant") || name.contains("Pain") -> "laminated AOP butter dough, natural yeast starter, and optional high-grade sweet fillings"
        name.contains("Cinnamon") -> "artisan dough filled with Indonesian cinnamon brown sugar paste, baked and glazed with cream cheese frosting"
        name.contains("Muffin") -> "moist buttermilk batter, fresh orchard blueberries, vanilla bean paste, and a buttery crumble top"
        name.contains("Tiramisu") -> "savoiardi ladyfingers soaked in espresso, layered with whipped mascarpone cream cheese, and dusted with dark cocoa powder"
        name.contains("Cheesecake") -> "Philadelphia style cream cheese, golden graham cracker crust, and sweet berry compote"
        name.contains("Toast") -> "artisan sourdough bread, crushed Haas avocados, pink Himalayan salt, and extra virgin olive oil"
        name.contains("Sandwich") || name.contains("Panini") || name.contains("Wrap") -> {
            if (name.contains("Chicken")) "tender shredded grilled chicken breast, house garlic aioli, Swiss cheese, and organic field greens"
            else "grilled zucchini, bell peppers, melted provolone cheese, pesto spread, and organic field greens"
        }
        name.contains("Mojito") || name.contains("Cooler") || name.contains("Refresher") || name.contains("Blue Lagoon") -> "freshly squeezed key limes, hand-torn mint leaves, organic cane syrup, and carbonated spring water"
        else -> "fresh, high-quality handpicked ingredients selected specifically for their rich aroma and exceptional freshness"
    }

    val servingInfo = when {
        category.contains("Hot Coffee") || name.contains("Hot") -> "Served piping hot at exactly 65°C in an insulated double-walled ceramic cup, accompanied by a complimentary crisp cinnamon biscuit."
        name.contains("Iced") || name.contains("Cold") || name.contains("Brew") || name.contains("Refresher") || name.contains("Shake") || name.contains("Mojito") || name.contains("Cooler") || name.contains("Lagoon") -> "Served chilled in a tall chilled glassware over hand-carved ice spheres, complete with an eco-friendly straw and fresh mint garnish."
        category.contains("Tea") -> "Presented elegantly in an authentic clay pot or glass teapot alongside a porcelain sipping cup and raw organic honey."
        category.contains("Bakery") || category.contains("Dessert") -> "Served warmed up to request on a gold-rimmed ceramic plate, beautifully dusted with powdered sugar or cocoa powder."
        category.contains("Snacks") -> "Complimented with a side of house-made sweet potato crisps and refreshing spicy tomato relish or classic garlic dip."
        else -> "Warmed to a perfect temperature and impeccably presented with artistic garnishes."
    }

    val signatureProfile = when {
        name.contains("Espresso") -> "characterized by a heavy body and intense bittersweet finish that leaves a memorable, velvety lingering chocolate sensation."
        name.contains("Cappuccino") -> "featuring a perfectly structured thick layer of foam that holds its temperature, sealing in the delicious espresso warmth beneath."
        name.contains("Latte") -> "a pristine iced option presenting beautifully layered milk and rich espresso over clear ice cubes."
        name.contains("Cold Brew") -> "a patience-crafted classic with an incredibly clean profile, low acidity, and natural milk chocolate undertones."
        name.contains("Frappé") -> "an indulgent blended shake featuring real crushed Oreo cookie chunks, sweet cream, and a splash of espresso."
        name.contains("Shake") -> "thick, decadent, and incredibly chocolatey, designed for those who appreciate premium dessert shakes."
        name.contains("Tea") || name.contains("Chai") -> "brewed with absolute devotion, letting the aromatic spices release their warm oils directly into the creamy tea bubble."
        name.contains("Chocolate") || name.contains("Cocoa") -> "thick, dark, and intensely cocoa-centric, crafted with premium Belgian chocolate drops melted slowly into milk."
        name.contains("Croissant") -> "offering 24 distinct flaky layers of premium laminations that shatter delightfully with every bite."
        name.contains("Cake") || name.contains("Tiramisu") || name.contains("Cheesecake") -> "a gorgeous dessert presenting a fine flavor paired elegantly with rich textures."
        name.contains("Brownie") -> "fudgy and chewy, prepared with premium cocoa butter and premium dark chocolate chunks, served warm."
        name.contains("Toast") || name.contains("Sandwich") || name.contains("Wrap") || name.contains("Bagel") || name.contains("Quiche") || name.contains("McMuffin") -> "piled high with fresh ingredients, delivering a satisfying crunch and burst of flavor."
        name.contains("Mojito") || name.contains("Refresher") -> "muddled fresh fruit combined with lime juice, garden mint, and premium fizzy soda over crushed ice."
        id == "s1" -> "an extraordinary, ultimate sensory masterpiece of Aurum Café, featuring double-extracted premium Arabica beans, organic acacia honey, and a spectacular dusting of 24-Karat edible gold flakes to elevate your elite coffee experience."
        id == "s2" -> "a highly sophisticated espresso pull, masterfully combined with imported, highly aromatic European black truffle essence for an exceptionally savory, earthy undertone that has redefined specialty craft coffee."
        id == "s3" -> "brewed with absolute devotion using the world's most expensive spice, integrating hand-harvested Kashmiri saffron strands with heavy sweet cream and double-ristretto to create a brilliant amber-hued luxury cup."
        id == "s4" -> "an unmatched gourmet toast pairing, overlaying thick toasted French artisan sourdough with rich espresso-infused cream cheese and a delicate topping of salted premium caviar for a stunning ocean-meets-cafe flavour profile."
        id == "s5" -> "a magnificent pastry creation, offering 24 layers of hand-laminated french butter croissant pastry wrapped elegantly in 24K edible gold leaf, revealing a rich, melting dark hazelnut core upon your first warm bite."
        id == "s6" -> "sourced directly from the mist-shrouded fields of Uji, Japan, this rare ceremonial grade matcha matcha is hand-whisked into silky hot oat milk to reveal a sweet, deep umami flavor reserved for royalty."
        else -> "a signature culinary creation utilizing our premium proprietary ingredients, precisely prepared to deliver an unmatched texture, outstanding visual presentation, and full-bodied classic coffeehouse flavor profile."
    }

    return "Presenting $name, a custom addition in our $category collection. " +
           "Originating from the finest secrets of $cuisine, this exquisite item is prepared using a refined style of $prepStyle. " +
           "Crafted with handpicked premium ingredients including $ingredients, each serving is $signatureProfile " +
           "$servingInfo"
}

fun validateProductDescriptions() {
    val allProducts = sampleProducts + specialProducts
    val descriptions = mutableMapOf<String, String>()
    val duplicates = mutableListOf<String>()

    for (p in allProducts) {
        val d = getUniqueProductDescription(p)
        val existingEntry = descriptions.entries.find { it.value == d }
        if (existingEntry != null) {
            duplicates.add("Duplicate found! Product: '${p.name}' (ID: ${p.id}) has the same description as Product: '${existingEntry.key}'")
        }
        descriptions[p.id] = d
    }

    if (duplicates.isEmpty()) {
        android.util.Log.d("AurumCafeValidation", "SUCCESS: All ${allProducts.size} product descriptions are 100% unique and item-specific!")
    } else {
        android.util.Log.e("AurumCafeValidation", "WARNING: Duplicates found in product descriptions!\n" + duplicates.joinToString("\n"))
    }
}

data class CustomizationOption(val name: String, val price: Int)

fun getProductSizes(product: Product, basePrice: Int): Map<String, Int> {
    val category = product.category
    val name = product.name
    return when {
        category.contains("Coffee") || category.contains("Tea") || category.contains("Refreshers") || category.contains("Signature") -> {
            mapOf("Small" to basePrice, "Medium" to basePrice + 30, "Large" to basePrice + 60)
        }
        category.contains("Bakery") || category.contains("Dessert") -> {
            if (name.contains("Cake") || name.contains("Cheesecake") || name.contains("Tiramisu") || name.contains("Tart")) {
                mapOf("Regular Slice" to basePrice, "Large Slice" to basePrice + 50)
            } else if (name.contains("Macaron")) {
                mapOf("Set of 3" to basePrice, "Set of 6" to basePrice * 2)
            } else {
                mapOf("Regular" to basePrice)
            }
        }
        category.contains("Snacks") -> {
            mapOf("Regular Portion" to basePrice, "Large Portion" to basePrice + 60)
        }
        else -> mapOf("Regular" to basePrice)
    }
}

fun getProductCustomizations(product: Product): List<CustomizationOption> {
    val category = product.category
    val name = product.name
    
    val options = mutableListOf<CustomizationOption>()
    
    if (category.contains("Coffee")) {
        options.add(CustomizationOption("Extra Shot", 30))
        if (name.contains("Iced") || name.contains("Cold") || name.contains("Frappé") || name.contains("Shake")) {
            options.add(CustomizationOption("Less Ice", 0))
            if (name.contains("Frappé")) options.add(CustomizationOption("Extra Blended", 0))
            else options.add(CustomizationOption("Cold Foam", 40))
        } else {
            options.add(CustomizationOption("Extra Hot", 0))
        }
        options.add(CustomizationOption("Oat Milk", 40))
        options.add(CustomizationOption("Almond Milk", 40))
        
        if (!name.contains("Vanilla")) options.add(CustomizationOption("Vanilla Syrup", 25))
        if (!name.contains("Caramel")) options.add(CustomizationOption("Caramel Syrup", 25))
        if (!name.contains("Hazelnut")) options.add(CustomizationOption("Hazelnut Syrup", 25))
        
        options.add(CustomizationOption("No Sugar", 0))
        options.add(CustomizationOption("Less Sugar", 0))
        if (name.contains("Latte") || name.contains("Mocha") || name.contains("Frappé") || name.contains("Shake")) {
            options.add(CustomizationOption("Whipped Cream", 30))
        }
    } else if (category.contains("Tea")) {
        options.add(CustomizationOption("Honey", 20))
        options.add(CustomizationOption("Lemon Slice", 10))
        options.add(CustomizationOption("Extra Mint", 15))
        if (name.contains("Milk") || name.contains("Chai") || name.contains("Matcha")) {
            options.add(CustomizationOption("Oat Milk", 40))
            options.add(CustomizationOption("Extra Strong", 20))
        }
        options.add(CustomizationOption("No Sugar", 0))
        options.add(CustomizationOption("Less Sugar", 0))
    } else if (category.contains("Bakery")) {
        options.add(CustomizationOption("Warmed Up", 0))
        options.add(CustomizationOption("Extra Butter", 15))
        options.add(CustomizationOption("Strawberry Jam", 20))
        if (name.contains("Croissant") || name.contains("Pain")) {
            options.add(CustomizationOption("Nutella Spread", 30))
        }
    } else if (category.contains("Dessert")) {
        options.add(CustomizationOption("Add Vanilla Ice Cream", 60))
        options.add(CustomizationOption("Extra Chocolate Sauce", 25))
        options.add(CustomizationOption("Extra Caramel Sauce", 25))
        options.add(CustomizationOption("Extra Whipped Cream", 30))
        if (name.contains("Cake") || name.contains("Cheesecake")) {
            options.add(CustomizationOption("Birthday Candle", 10))
        }
    } else if (name.contains("Sandwich") || name.contains("Wrap") || name.contains("Toast") || name.contains("Panini") || category.contains("Snacks")) {
        options.add(CustomizationOption("Extra Cheese", 30))
        if (!name.contains("Avocado")) options.add(CustomizationOption("Extra Protein", 60))
        options.add(CustomizationOption("Extra Toasted", 0))
        options.add(CustomizationOption("Garlic Mayo", 20))
        options.add(CustomizationOption("Spicy Sauce", 15))
        options.add(CustomizationOption("Side Chips", 40))
    } else if (category.contains("Refreshers")) {
        options.add(CustomizationOption("Less Ice", 0))
        options.add(CustomizationOption("No Ice", 0))
        options.add(CustomizationOption("Extra Mint", 15))
        options.add(CustomizationOption("Extra Lemon", 15))
        options.add(CustomizationOption("Less Sweet", 0))
    } else if (category.contains("Signature")) {
        if (name.contains("Coffee") || name.contains("Latte") || name.contains("Espresso") || name.contains("Cappuccino")) {
            options.add(CustomizationOption("Extra Shot", 30))
            options.add(CustomizationOption("Oat Milk", 40))
        }
        if (name.contains("Gold") || name.contains("Aurum")) {
            options.add(CustomizationOption("Extra Gold Flakes", 100))
        }
        options.add(CustomizationOption("Gift Packaging", 50))
    } else {
        options.add(CustomizationOption("Special Packaging", 20))
    }
    
    return options
}

val allSampleProducts = mutableListOf(
  Product("1", "Espresso Shot", "Hot Coffee", "Strong & Bold single shot", "4.9", "₹99", R.drawable.espresso_shot),
  Product("4", "Cappuccino", "Hot Coffee", "Classic Italian blend", "4.8", "₹159", R.drawable.cappuccino),
  Product("6", "Mocha Latte", "Hot Coffee", "Chocolate & espresso", "4.8", "₹169", R.drawable.mocha_latte_item),

  Product("17", "Iced Latte", "Cold Coffee", "Refreshing milky espresso", "4.7", "₹169", R.drawable.iced_latte),
  Product("20", "Cold Brew", "Cold Coffee", "Steeped smooth brew", "4.9", "₹179", R.drawable.cold_brew),
  Product("26", "Oreo Frappé", "Cold Coffee", "Cookies and cream blend", "4.8", "₹229", R.drawable.oreo_frappe),
  Product("27", "Chocolate Coffee Shake", "Cold Coffee", "Thick chocolate espresso", "4.9", "₹239", R.drawable.chocolate_coffee_shake),

  Product("30", "Masala Chai", "Tea", "Spiced Indian classic", "4.9", "₹119", R.drawable.masala_chai),
  Product("31", "Green Tea", "Tea", "Light & healthy", "4.5", "₹109", R.drawable.green_tea),
  Product("37", "Matcha Latte", "Tea", "Earthy green creamy", "4.9", "₹199", R.drawable.matcha_latte),

  Product("38", "Belgian Hot Chocolate", "Signature", "Rich dark cocoa", "4.9", "₹219", R.drawable.belgian_hot_chocolate),
  Product("41", "Salted Caramel Cocoa", "Signature", "Sweet salty richness", "4.9", "₹229", R.drawable.salted_caramel_cocoa),

  Product("46", "Butter Croissant", "Bakery", "Flaky & buttery", "4.8", "₹129", R.drawable.butter_croissant),
  Product("48", "Chocolate Croissant", "Bakery", "Dark chocolate center", "4.9", "₹149", R.drawable.chocolate_croissant),
  Product("56", "Red Velvet Slice", "Bakery", "Cream cheese frosting", "4.8", "₹179", R.drawable.red_velvet_slice),

  Product("58", "Classic Tiramisu", "Dessert", "Coffee-soaked delight", "4.9", "₹249", R.drawable.classic_tiramisu),
  Product("60", "Chocolate Brownie", "Dessert", "Gooey & warm", "4.8", "₹149", R.drawable.chocolate_brownie),
  Product("66", "Lotus Biscoff Cheesecake", "Dessert", "Caramelized biscuit", "5.0", "₹269", R.drawable.lotus_biscoff_cheesecake),

  Product("68", "Avocado Toast", "Snacks", "Healthy & fresh", "4.8", "₹229", R.drawable.avocado_toast),
  Product("69", "Classic Club Sandwich", "Snacks", "Layered chicken & veg", "4.7", "₹199", R.drawable.classic_club_sandwich, isVeg = false),
  Product("74", "Veg Wrap", "Snacks", "Crunchy & fresh", "4.5", "₹159", R.drawable.veg_wrap),
  Product("76", "Breakfast Croissant Sandwich", "Snacks", "Egg & cheese", "4.9", "₹239", R.drawable.breakfast_croissant_sandwich, isVeg = false),

  Product("79", "Strawberry Mojito", "Refreshers", "Mint & strawberry", "4.7", "₹179", R.drawable.strawberry_mojito),
  Product("84", "Watermelon Refresher", "Refreshers", "Fresh watermelon", "4.8", "₹179", R.drawable.watermelon_refresher),
  
  Product("90", "Chicken Tikka Croissant", "Bakery", "Spicy marinated roasted chicken in flaky pastry", "4.8", "₹189", R.drawable.chicken_tikka_croissant, isVeg = false),
  Product("91", "Smoked Salmon Bagel", "Bakery", "Artisan bagel with cream cheese & smoked salmon", "4.9", "₹299", R.drawable.smoked_salmon_bagel, isVeg = false),
  Product("92", "Spicy Chicken Club Wrap", "Snacks", "Grilled chicken breasts with loaded cheese & greens", "4.7", "₹219", R.drawable.spicy_chicken_club_wrap, isVeg = false),
  Product("93", "Peri Peri Chicken Quiche", "Bakery", "Rich savory egg custard tart with peri-peri chicken", "4.6", "₹199", R.drawable.peri_peri_chicken_quiche, isVeg = false),
  Product("94", "Egg & Bacon McMuffin", "Snacks", "Toasted muffin with crispy bacon & fried egg", "4.8", "₹249", R.drawable.egg_bacon_mcmuffin, isVeg = false),
  Product("95", "BBQ Chicken Turnover", "Bakery", "Puff pastry stuffed with smoky barbecue chicken", "4.7", "₹179", R.drawable.bbq_chicken_turnover, isVeg = false)
)

val specialProducts = listOf(
  Product("s1", "Aurum Golden Latte", "Signature", "Infused with 24K edible gold flakes", "5.0", "₹599", R.drawable.aurum_golden_latte),
  Product("s2", "Truffle Infused Espresso", "Signature", "Rich espresso with European black truffle", "4.9", "₹499", R.drawable.truffle_infused_espresso),
  Product("s3", "Saffron Cappuccino", "Signature", "Premium grade saffron blended cream", "4.8", "₹449", R.drawable.saffron_cappuccino),
  Product("s4", "Caviar Coffee Toast", "Bakery", "Artisan sourdough with coffee cream & caviar", "5.0", "₹899", R.drawable.caviar_coffee_toast, isVeg = false),
  Product("s5", "Gold Leaf Croissant", "Bakery", "Flaky layered goodness wrapped in gold", "4.7", "₹699", R.drawable.gold_leaf_croissant),
  Product("s6", "Emerald Matcha Reserve", "Signature", "Finest ceremonial grade imported matcha", "4.9", "₹799", R.drawable.emerald_matcha_reserve)
)

val sampleProducts = allSampleProducts.toMutableList()

data class CartItem(
  val id: String = java.util.UUID.randomUUID().toString(),
  val product: Product,
  val size: String,
  val price: Int,
  var quantity: Int = 1,
  val extras: List<String> = emptyList()
)

data class Order(
  val id: String,
  val date: String,
  val status: String,
  val items: List<CartItem>,
  val total: Int
)

val sampleOrders = listOf<Order>()

@Composable
fun AnimatedProductCard(product: Product, index: Int, isVisible: Boolean, isFavorite: Boolean, onToggleFavorite: () -> Unit, onClick: () -> Unit, onAddToCart: () -> Unit = {}) {
  ProductCard(product, isFavorite, onToggleFavorite, onClick, onAddToCart)
}

@Composable
fun ProductCard(product: Product, isFavorite: Boolean, onToggleFavorite: () -> Unit, onClick: () -> Unit, onAddToCart: () -> Unit = {}) {
  val haptic = LocalHapticFeedback.current
  
  val favScale by animateFloatAsState(
    targetValue = if (isFavorite) 1.25f else 1f,
    animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy), label = "favBounce"
  )

  Card(
    modifier = Modifier
      .fillMaxWidth()
      .graphicsLayer {
        // Soft elevated shadow structure
        shadowElevation = 8f
        shape = RoundedCornerShape(20.dp)
        clip = true
      }
      .clickable(onClick = onClick)
      .border(width = 1.dp, color = Color(0xFFF7F2EC).copy(alpha = 0.8f), shape = RoundedCornerShape(20.dp)),
    shape = RoundedCornerShape(20.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White)
  ) {
    Column(
      modifier = Modifier.padding(10.dp)
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .aspectRatio(1.05f)
          .clip(RoundedCornerShape(16.dp))
      ) {
        // Product Image - Rendered with Coil AsyncImage safely on separate thread with downsampling
        AsyncImage(
          model = product.imageRes,
          contentDescription = product.name,
          modifier = Modifier.fillMaxSize(),
          contentScale = ContentScale.Crop
        )

        // Subtle gradient vignette overlay at the bottom of image
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(
              Brush.verticalGradient(
                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.25f))
              )
            )
        )

        // Veg / Non-Veg Standard Premium Badge
        Box(
          modifier = Modifier
            .align(Alignment.TopStart)
            .padding(10.dp)
            .size(16.dp)
            .background(Color.White, RoundedCornerShape(4.dp))
            .border(1.dp, if (product.isVeg) Color(0xFF4CAF50) else Color(0xFFE53935), RoundedCornerShape(4.dp)),
          contentAlignment = Alignment.Center
        ) {
          Box(
            modifier = Modifier
              .size(6.dp)
              .background(if (product.isVeg) Color(0xFF4CAF50) else Color(0xFFE53935), CircleShape)
          )
        }

        // Translucent Floating Favorite Button in corner
        Box(
          modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(6.dp)
            .size(32.dp)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.85f))
            .clickable {
              onToggleFavorite()
              haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            },
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
            contentDescription = "Favorite",
            tint = if (isFavorite) Color(0xFFE53935) else Color(0xFF5A3214),
            modifier = Modifier.size(16.dp).scale(favScale)
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text = product.name,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        color = DarkCoffeeBrown,
        maxLines = 1,
        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
      )
      Spacer(modifier = Modifier.height(2.dp))
      Text(
        text = product.subtitle,
        fontSize = 11.sp,
        color = TextLightGrey,
        maxLines = 1,
        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
      )
      
      Spacer(modifier = Modifier.height(8.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.Star, contentDescription = "Rating", tint = Color(0xFFD4AF37), modifier = Modifier.size(13.dp))
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = product.rating, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = product.price,
            fontSize = 15.sp,
            fontWeight = FontWeight.Black,
            color = CaramelBrown
          )
        }

        // Elegant Dynamic Add to Cart (+) Button
        Box(
          modifier = Modifier
            .size(32.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(DarkCoffeeBrown)
            .clickable {
              onAddToCart()
              haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            },
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add to Cart",
            tint = Color.White,
            modifier = Modifier.size(16.dp)
          )
        }
      }
    }
  }
}

@Composable
fun CustomBottomNavBar(currentRoute: String, onNavigate: (String) -> Unit) {
  Box(
    modifier = Modifier
      .fillMaxWidth(),
    contentAlignment = Alignment.BottomCenter
  ) {
    // Nav Bar Background
    Card(
      shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
      elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
      colors = CardDefaults.cardColors(containerColor = CreamBackground),
      modifier = Modifier.fillMaxWidth().height(80.dp)
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 8.dp)
          .fillMaxHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
           BottomNavItem(icon = Icons.Filled.Home, selectedIcon = Icons.Filled.Home, label = "Home", isSelected = currentRoute == "home") { onNavigate("home") }
           BottomNavItem(icon = Icons.Outlined.LocalCafe, selectedIcon = Icons.Filled.Coffee, label = "Menu", isSelected = currentRoute == "catalog") { onNavigate("catalog") }
        }
        
        Spacer(modifier = Modifier.width(60.dp)) // Space for center FAB
        
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
           BottomNavItem(icon = Icons.Filled.FavoriteBorder, selectedIcon = Icons.Filled.Favorite, label = "Wishlist", isSelected = currentRoute == "wishlist") { onNavigate("wishlist") }
           BottomNavItem(icon = Icons.Filled.Person, selectedIcon = Icons.Filled.Person, label = "Account", isSelected = currentRoute == "account") { onNavigate("account") }
        }
      }
    }
    
    // Center FAB
    Box(
      modifier = Modifier
        .align(Alignment.TopCenter)
        .offset(y = (-30).dp)
        .size(64.dp)
        .shadow(8.dp, CircleShape)
        .clip(CircleShape)
        .background(Color(0xFF2C1E16)) // DarkCoffeeBrown
        .clickable { onNavigate("special") }, // Special Action
      contentAlignment = Alignment.Center
    ) {
        AurumLogo(size = 36.dp)
    }
  }
}

@Composable
fun BottomNavItem(icon: ImageVector, selectedIcon: ImageVector, label: String, isSelected: Boolean, onClick: () -> Unit) {
  val haptic = LocalHapticFeedback.current
  val scale by androidx.compose.animation.core.animateFloatAsState(targetValue = if (isSelected) 1.15f else 1f, animationSpec = androidx.compose.animation.core.tween(300, easing = androidx.compose.animation.core.FastOutSlowInEasing))
  val color by androidx.compose.animation.animateColorAsState(targetValue = if (isSelected) Color(0xFFE5A152) else TextLightGrey, animationSpec = androidx.compose.animation.core.tween(300))

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null,
        onClick = { 
          onClick()
          haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        }
      )
      .padding(8.dp)
  ) {
    Icon(
      imageVector = if (isSelected) selectedIcon else icon,
      contentDescription = label,
      tint = color,
      modifier = Modifier.size(18.dp).scale(scale)
    )
    Spacer(modifier = Modifier.height(4.dp))
    androidx.compose.animation.AnimatedVisibility(visible = isSelected) {
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
          text = label,
          fontSize = 10.sp,
          fontWeight = FontWeight.Bold,
          color = color
        )
        Spacer(modifier = Modifier.height(2.dp))
        Box(modifier = Modifier.width(16.dp).height(2.dp).background(color, RoundedCornerShape(1.dp)))
      }
    }
  }
}

@Composable
fun ProductDetailScreen(
  product: Product,
  wishlistItems: List<Product>,
  onToggleWishlist: () -> Unit,
  onBackClick: () -> Unit,
  onProceedToCheckout: (CartItem) -> Unit
) {
  var selectedSize by remember { mutableStateOf("M") }
  var quantity by remember { mutableStateOf(1) }
  val scrollState = rememberScrollState()
  val isFavorite = wishlistItems.contains(product)
  val haptic = LocalHapticFeedback.current

  val basePrice = product.price.replace("₹", "").toIntOrNull() ?: 129
  
  val sizeMPrice = basePrice
  val sizeSPrice = (basePrice * 0.76).toInt() // approx 99 for 129
  val sizeLPrice = (basePrice * 1.23).toInt() // approx 159 for 129
  
  val isBakeryOrFood = product.category.contains("Bakery") || product.category.contains("Dessert") || product.category.contains("Snacks")

  val selectedSizePrice = if (isBakeryOrFood) {
      basePrice
  } else {
      when(selectedSize) {
          "S" -> sizeSPrice
          "L" -> sizeLPrice
          else -> sizeMPrice
      }
  }

  val addons = remember { androidx.compose.runtime.mutableStateMapOf<String, Int>() }
  val addonsList = if (isBakeryOrFood) {
      listOf(
          Triple("Extra Cheese", 30, Icons.Filled.Add),
          Triple("Butter", 15, Icons.Filled.Star),
          Triple("Dip", 20, Icons.Filled.Eco),
          Triple("Ketchup", 0, Icons.Filled.Check)
      )
  } else {
      listOf(
          Triple("Extra Shot", 30, Icons.Filled.Add),
          Triple("Vanilla", 20, Icons.Filled.Eco),
          Triple("Caramel", 20, Icons.Filled.Star),
          Triple("Hazelnut", 20, Icons.Outlined.LocalFlorist),
          Triple("Mocha", 25, Icons.Filled.Coffee)
      )
  }

  val extrasCost = addons.values.sumOf { it }
  val singleItemPrice = selectedSizePrice + extrasCost
  val totalPrice = singleItemPrice * quantity
  val earnedBeans = (totalPrice * 0.1).toInt()

  val DarkBg = Color(0xFF261D19)
  val LightBg = Color(0xFFF9F6F2)
  val CardBg = Color(0xFFF6F0E6)
  val AccentBrown = Color(0xFFC89C76)
  val IconBg = Color(0xFF382921)

  var isCardHovered by remember { mutableStateOf(false) }
  val imageScale by androidx.compose.animation.core.animateFloatAsState(
      targetValue = if (isCardHovered) 1.05f else 1f,
      animationSpec = androidx.compose.animation.core.tween(500, easing = androidx.compose.animation.core.FastOutSlowInEasing), label = "imageScale"
  )

  Box(modifier = Modifier.fillMaxSize().background(LightBg)) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
        .padding(bottom = 120.dp)
    ) {
      Box(modifier = Modifier.fillMaxWidth()) {
        Image(
          painter = painterResource(id = product.imageRes),
          contentDescription = product.name,
          modifier = Modifier
            .fillMaxWidth()
            .height(420.dp)
            .graphicsLayer {
                translationY = scrollState.value * 0.4f
                scaleX = imageScale
                scaleY = imageScale
            },
          contentScale = ContentScale.Crop
        )
        
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp, start = 16.dp, end = 16.dp),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Box(
            modifier = Modifier.size(44.dp).clip(CircleShape).background(DarkBg.copy(alpha=0.8f)).clickable { onBackClick() },
            contentAlignment = Alignment.Center
          ) {
             Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
          Box(
            modifier = Modifier.size(44.dp).clip(CircleShape).background(Color.White.copy(alpha=0.9f)).clickable { onToggleWishlist(); haptic.performHapticFeedback(HapticFeedbackType.LongPress) },
            contentAlignment = Alignment.Center
          ) {
             Icon(if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder, contentDescription = "Favorite", tint = if (isFavorite) Color.Red else Color.Black)
          }
        }
        
        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .offset(y = 60.dp)
                .pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent(androidx.compose.ui.input.pointer.PointerEventPass.Initial)
                            val isPressedOrHovered = event.type == androidx.compose.ui.input.pointer.PointerEventType.Press || event.type == androidx.compose.ui.input.pointer.PointerEventType.Enter
                            val isReleasedOrExited = event.type == androidx.compose.ui.input.pointer.PointerEventType.Release || event.type == androidx.compose.ui.input.pointer.PointerEventType.Exit
                            if (isPressedOrHovered) {
                                isCardHovered = true
                            } else if (isReleasedOrExited) {
                                isCardHovered = false
                            }
                        }
                    }
                },
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = DarkBg)
        ) {
            Row(modifier = Modifier.fillMaxWidth().padding(24.dp), verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = product.name, color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold, maxLines = 2, overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis, lineHeight = 32.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    if (!isBakeryOrFood) {
                        Text(text = "Strong • Bold • Intense", color = AccentBrown, fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Row(modifier = Modifier.background(IconBg, CircleShape).padding(horizontal = 10.dp, vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Filled.Eco, contentDescription=null, tint=AccentBrown, modifier = Modifier.size(12.dp))
                                Spacer(Modifier.width(4.dp))
                                Text("Arabica Beans", color=Color.White, fontSize = 10.sp)
                            }
                            Row(modifier = Modifier.background(IconBg, CircleShape).padding(horizontal = 10.dp, vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Outlined.LocalFireDepartment, contentDescription=null, tint=AccentBrown, modifier = Modifier.size(12.dp))
                                Spacer(Modifier.width(4.dp))
                                Text("Dark Roast", color=Color.White, fontSize = 10.sp)
                            }
                        }
                    } else {
                        Text(text = product.category, color = AccentBrown, fontSize = 14.sp)
                    }
                }
                Box(modifier = Modifier.width(1.dp).height(80.dp).background(Color.White.copy(alpha = 0.1f)))
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(start = 20.dp)) {
                    Text("₹${selectedSizePrice}", color = Color.White, fontSize = 34.sp, fontWeight = FontWeight.ExtraBold)
                    Spacer(Modifier.height(4.dp))
                    Text("Inclusive of taxes", color = Color.White.copy(alpha = 0.6f), fontSize = 11.sp)
                }
            }
        }
      }
      
      Spacer(modifier = Modifier.height(100.dp))

      Column(modifier = Modifier.padding(horizontal = 24.dp)) {
          if (!isBakeryOrFood) {
              Text("ROAST & STRENGTH", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = DarkBg.copy(alpha=0.8f), letterSpacing = 1.sp)
              Spacer(modifier = Modifier.height(16.dp))
              Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                  Card(
                      modifier = Modifier.weight(1f),
                      shape = RoundedCornerShape(20.dp),
                      colors = CardDefaults.cardColors(containerColor = CardBg)
                  ) {
                      Column(modifier = Modifier.padding(20.dp)) {
                          Row(verticalAlignment = Alignment.CenterVertically) {
                              Icon(Icons.Filled.Star, contentDescription=null, tint=DarkBg, modifier=Modifier.size(14.dp))
                              Spacer(Modifier.width(8.dp))
                              Text("Roast Level", fontSize = 14.sp, color = DarkBg, fontWeight = FontWeight.SemiBold)
                          }
                          Spacer(modifier = Modifier.height(16.dp))
                          Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                              repeat(4) { Box(modifier = Modifier.size(12.dp).background(DarkBg, CircleShape)) }
                              Box(modifier = Modifier.size(12.dp).background(Color.LightGray, CircleShape))
                          }
                          Spacer(modifier = Modifier.height(8.dp))
                          Text("Dark", fontSize = 13.sp, color = DarkBg.copy(alpha=0.7f))
                      }
                  }
                  Card(
                      modifier = Modifier.weight(1f),
                      shape = RoundedCornerShape(20.dp),
                      colors = CardDefaults.cardColors(containerColor = CardBg)
                  ) {
                      Column(modifier = Modifier.padding(20.dp)) {
                          Row(verticalAlignment = Alignment.CenterVertically) {
                              Icon(Icons.Filled.LocalFireDepartment, contentDescription=null, tint=DarkBg, modifier=Modifier.size(16.dp))
                              Spacer(Modifier.width(8.dp))
                              Text("Strength", fontSize = 14.sp, color = DarkBg, fontWeight = FontWeight.SemiBold)
                          }
                          Spacer(modifier = Modifier.height(16.dp))
                          Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                              repeat(4) { Box(modifier = Modifier.size(12.dp).background(AccentBrown, CircleShape)) }
                              Box(modifier = Modifier.size(12.dp).background(Color.LightGray, CircleShape))
                          }
                          Spacer(modifier = Modifier.height(8.dp))
                          Text("Strong", fontSize = 13.sp, color = DarkBg.copy(alpha=0.7f))
                      }
                  }
              }

              Spacer(modifier = Modifier.height(32.dp))

              Text("CHOOSE SIZE", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = DarkBg.copy(alpha=0.8f), letterSpacing = 1.sp)
              Spacer(modifier = Modifier.height(16.dp))
              Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                  listOf("S" to sizeSPrice, "M" to sizeMPrice, "L" to sizeLPrice).forEach { (sizeTag, price) ->
                      val isSelected = selectedSize == sizeTag
                      val bgColor = if (isSelected) DarkBg else CardBg
                      val textColor = if (isSelected) Color.White else DarkBg
                      val sizeName = when(sizeTag) { "S" -> "Small"; "M" -> "Medium"; else -> "Large" }
                      
                      Card(
                          modifier = Modifier.weight(1f).aspectRatio(1.1f).clickable { selectedSize = sizeTag; haptic.performHapticFeedback(HapticFeedbackType.LongPress) },
                          shape = RoundedCornerShape(20.dp),
                          colors = CardDefaults.cardColors(containerColor = bgColor)
                      ) {
                          Box(modifier = Modifier.fillMaxSize()) {
                              Column(
                                  modifier = Modifier.fillMaxSize(),
                                  horizontalAlignment = Alignment.CenterHorizontally,
                                  verticalArrangement = Arrangement.Center
                              ) {
                                  Text(sizeTag, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = textColor)
                                  Spacer(Modifier.height(4.dp))
                                  Text(sizeName, fontSize = 13.sp, color = textColor)
                                  Spacer(Modifier.height(6.dp))
                                  Text("₹$price", fontSize = 13.sp, color = textColor.copy(alpha=0.8f))
                              }
                              if (isSelected) {
                                  Box(modifier = Modifier.align(Alignment.TopEnd).padding(10.dp).size(20.dp).background(Color.White, CircleShape), contentAlignment = Alignment.Center) {
                                      Icon(Icons.Filled.Check, contentDescription = null, tint = DarkBg, modifier = Modifier.size(14.dp))
                                  }
                              }
                          }
                      }
                  }
              }
              Spacer(modifier = Modifier.height(32.dp))
          }

          val customizeText = if (isBakeryOrFood) "CUSTOMIZE YOUR FOOD" else "CUSTOMIZE YOUR COFFEE"
          Text(customizeText, fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = DarkBg.copy(alpha=0.8f), letterSpacing = 1.sp)
          Spacer(modifier = Modifier.height(16.dp))
          Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
              addonsList.forEach { (name, price, icon) ->
                  val isSelected = addons.containsKey(name)
                  Column(
                      horizontalAlignment = Alignment.CenterHorizontally,
                      modifier = Modifier.clickable { 
                          if (isSelected) addons.remove(name) else addons[name] = price
                          haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                      }
                  ) {
                      Box(
                          modifier = Modifier
                              .size(76.dp)
                              .background(if (isSelected) CardBg else Color.Transparent, CircleShape)
                              .border(1.dp, if (isSelected) AccentBrown else DarkBg.copy(alpha=0.2f), CircleShape),
                          contentAlignment = Alignment.Center
                      ) {
                          Box(modifier = Modifier.size(44.dp).background(if (isSelected) AccentBrown else CardBg, CircleShape), contentAlignment = Alignment.Center) {
                              Icon(icon, contentDescription = name, tint = if (isSelected) Color.White else AccentBrown, modifier = Modifier.size(22.dp))
                          }
                      }
                      Spacer(modifier = Modifier.height(10.dp))
                      Text(name, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = DarkBg)
                      Text("+₹$price", fontSize = 12.sp, color = DarkBg.copy(alpha=0.6f))
                  }
              }
          }
          
          Spacer(modifier = Modifier.height(40.dp))

          Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = Color(0xFFEFE6D8))
          ) {
              Row(
                  modifier = Modifier.fillMaxWidth().padding(16.dp),
                  verticalAlignment = Alignment.CenterVertically
              ) {
                  Box(modifier = Modifier.size(44.dp).background(DarkBg, RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center) {
                      Icon(Icons.Filled.Star, contentDescription = null, tint = AccentBrown, modifier = Modifier.size(24.dp))
                  }
                  Spacer(Modifier.width(12.dp))
                  Column {
                      Row {
                          Text("You earn ", fontSize = 15.sp, color = DarkBg, fontWeight = FontWeight.Medium)
                          Text("$earnedBeans Beans", fontSize = 15.sp, color = AccentBrown, fontWeight = FontWeight.Bold)
                      }
                      Text("on this order", fontSize = 13.sp, color = DarkBg.copy(alpha=0.7f))
                  }
              }
          }
      }
    }
    
    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .background(LightBg)
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(24.dp))
                    .border(1.dp, CardBg, RoundedCornerShape(24.dp))
                    .padding(horizontal = 4.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.size(44.dp).clip(CircleShape).clickable { if (quantity > 1) { quantity--; haptic.performHapticFeedback(HapticFeedbackType.LongPress) } },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Filled.Remove, contentDescription = "-", tint = DarkBg, modifier = Modifier.size(20.dp))
                }
                Text("$quantity", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = DarkBg, modifier = Modifier.padding(horizontal = 16.dp))
                Box(
                    modifier = Modifier.size(44.dp).clip(CircleShape).clickable { quantity++; haptic.performHapticFeedback(HapticFeedbackType.LongPress) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "+", tint = DarkBg, modifier = Modifier.size(20.dp))
                }
            }
            
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp)
                    .height(56.dp)
                    .background(DarkBg, RoundedCornerShape(20.dp))
                    .clickable {
                        val finalSize = if (isBakeryOrFood) "Regular" else selectedSize
                        val extrasList = addons.keys.toList()
                        onProceedToCheckout(CartItem(product = product, size = finalSize, price = singleItemPrice, quantity = quantity, extras = extrasList))
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    },
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.ShoppingBag, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(10.dp))
                    Text("Add to Cart  •  ₹$totalPrice", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
  }
}

@Composable
fun CartScreen(
  cartItems: List<CartItem>,
  onBackClick: () -> Unit,
  onCheckout: () -> Unit,
  onRemoveItem: (CartItem) -> Unit,
  onUpdateQuantity: (CartItem, Int) -> Unit,
  onClearCart: () -> Unit
) {
  val total = cartItems.sumOf { it.price * it.quantity }
  val gst = (total * 0.05).toInt()
  val convenienceFee = if (cartItems.isEmpty()) 0 else 20
  val discount = if (total > 800) (total * 0.1).toInt() else 0
  val grandTotal = (total - discount) + gst + convenienceFee

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(CreamBackground)
  ) {
    // Top Bar
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(44.dp)
          .clip(CircleShape)
          .border(1.dp, Color.LightGray.copy(alpha = 0.5f), CircleShape)
          .clickable { onBackClick() },
        contentAlignment = Alignment.Center
      ) {
         Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = TextDarkGrid)
      }
      Spacer(modifier = Modifier.width(16.dp))
      Column(modifier = Modifier.weight(1f)) {
         Text("Your Cart", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
         Text("Review your items and proceed to checkout", fontSize = 12.sp, color = TextLightGrey)
      }
      Box(
        modifier = Modifier
          .size(44.dp)
          .clip(CircleShape)
          .border(1.dp, Color.LightGray.copy(alpha = 0.5f), CircleShape)
          .clickable { onClearCart() },
        contentAlignment = Alignment.Center
      ) {
         Icon(Icons.Outlined.DeleteOutline, contentDescription = "Clear", tint = DarkCoffeeBrown)
      }
    }

    if (cartItems.isEmpty()) {
      Box(modifier = Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text("Your cart is empty", fontSize = 16.sp, color = TextLightGrey)
      }
    } else {
      LazyColumn(
        modifier = Modifier.weight(1f),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(start = 16.dp, end = 16.dp, bottom = 24.dp)
      ) {
        // Items
        items(cartItems, key = { it.product.id + it.size }) { item ->
          Card(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = LightBeige),
            elevation = CardDefaults.cardElevation(0.dp)
          ) {
            Row(modifier = Modifier.padding(12.dp)) {
              Box(
                modifier = Modifier
                  .size(100.dp)
                  .clip(RoundedCornerShape(16.dp))
                  .background(Color.White)
              ) {
                  Image(
                    painter = painterResource(id = item.product.imageRes),
                    contentDescription = item.product.name,
                    modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                  )
              }
              Spacer(modifier = Modifier.width(16.dp))
              Column(modifier = Modifier.weight(1f).height(100.dp), verticalArrangement = Arrangement.SpaceBetween) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
                  Column(modifier = Modifier.weight(1f)) {
                    Text(text = item.product.name, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid, maxLines = 1, overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis)
                    val extrasText = if (item.extras.isNotEmpty()) " + ${item.extras.joinToString(", ")}" else ""
                    Text(text = "${item.size}$extrasText", fontSize = 12.sp, color = TextLightGrey)
                  }
                  Spacer(modifier = Modifier.width(8.dp))
                  Box(modifier = Modifier.size(28.dp).clip(CircleShape).border(1.dp, Color.LightGray.copy(alpha=0.4f), CircleShape).clickable{ onRemoveItem(item) }, contentAlignment = Alignment.Center) {
                     Icon(Icons.Outlined.Close, contentDescription = "Remove", modifier = Modifier.size(16.dp), tint = TextDarkGrid)
                  }
                }
                
                Text(text = "₹${item.price}", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = DarkCoffeeBrown)

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                  Row(
                    modifier = Modifier.clip(RoundedCornerShape(16.dp)).background(Color.White).padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Box(modifier = Modifier.size(28.dp).clip(CircleShape).background(Color.Transparent).clickable { if(item.quantity > 1) onUpdateQuantity(item, item.quantity - 1) }, contentAlignment = Alignment.Center) {
                       Icon(Icons.Filled.Remove, contentDescription = "-", tint = DarkCoffeeBrown, modifier = Modifier.size(16.dp))
                    }
                    Text("${item.quantity}", modifier = Modifier.padding(horizontal = 12.dp), fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TextDarkGrid)
                    Box(modifier = Modifier.size(28.dp).clip(CircleShape).background(DarkCoffeeBrown).clickable { onUpdateQuantity(item, item.quantity + 1) }, contentAlignment = Alignment.Center) {
                       Icon(Icons.Filled.Add, contentDescription = "+", tint = Color.White, modifier = Modifier.size(16.dp))
                    }
                  }
                  
                  Text(text = "₹${item.price * item.quantity}", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
                }
              }
            }
          }
        } // end items

        // Add note instruction box
        item {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .padding(bottom = 24.dp)
              .drawBehind {
                  drawRoundRect(
                      color = Color.LightGray.copy(alpha=0.6f),
                      style = androidx.compose.ui.graphics.drawscope.Stroke(
                          width = 2f,
                          pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 15f), 0f)
                      ),
                      cornerRadius = androidx.compose.ui.geometry.CornerRadius(16.dp.toPx())
                  )
              }
              .padding(16.dp)
          ) {
             Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.CardGiftcard, contentDescription = null, tint = DarkCoffeeBrown, modifier = Modifier.size(32.dp))
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                   Text("Add a note or special instructions", fontWeight = FontWeight.SemiBold, color = TextDarkGrid, fontSize = 14.sp)
                   Text("We'll do our best to make it perfect", color = TextLightGrey, fontSize = 12.sp)
                }
                Text(">", fontSize = 20.sp, color = TextLightGrey)
             }
          }
        }

        // Bill Details
        item {
          Card(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = LightBeige),
            elevation = CardDefaults.cardElevation(0.dp)
          ) {
             Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                   Box(modifier = Modifier.size(36.dp).clip(CircleShape).background(Color.White).border(1.dp, Color.LightGray.copy(alpha=0.3f), CircleShape), contentAlignment = Alignment.Center) {
                      Icon(Icons.AutoMirrored.Outlined.ReceiptLong, contentDescription = null, tint = DarkCoffeeBrown, modifier = Modifier.size(20.dp))
                   }
                   Spacer(modifier = Modifier.width(12.dp))
                   Text("Bill Details", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
                }
                Spacer(modifier = Modifier.height(20.dp))
                
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                   Row(verticalAlignment = Alignment.CenterVertically) {
                      Icon(Icons.Filled.LocalMall, contentDescription = null, tint = TextLightGrey, modifier = Modifier.size(16.dp))
                      Spacer(modifier = Modifier.width(8.dp))
                      Text("Subtotal", fontSize = 14.sp, color = TextDarkGrid)
                   }
                   Text("₹$total", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = TextDarkGrid)
                }
                Spacer(modifier = Modifier.height(12.dp))
                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray.copy(alpha=0.3f)))
                Spacer(modifier = Modifier.height(12.dp))
                
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                   Row(verticalAlignment = Alignment.CenterVertically) {
                      Icon(Icons.AutoMirrored.Outlined.ReceiptLong, contentDescription = null, tint = TextLightGrey, modifier = Modifier.size(16.dp))
                      Spacer(modifier = Modifier.width(8.dp))
                      Text("GST & Platform tax (5%)", fontSize = 14.sp, color = TextDarkGrid)
                   }
                   Text("₹$gst", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = TextDarkGrid)
                }
                Spacer(modifier = Modifier.height(12.dp))
                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray.copy(alpha=0.3f)))
                Spacer(modifier = Modifier.height(12.dp))
                
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                   Row(verticalAlignment = Alignment.CenterVertically) {
                      Icon(Icons.Filled.LocalMall, contentDescription = null, tint = TextLightGrey, modifier = Modifier.size(16.dp))
                      Spacer(modifier = Modifier.width(8.dp))
                      Text("Convenience Fee", fontSize = 14.sp, color = TextDarkGrid)
                   }
                   Text("₹$convenienceFee", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = TextDarkGrid)
                }
                
                if (discount > 0) {
                   Spacer(modifier = Modifier.height(12.dp))
                   Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray.copy(alpha=0.3f)))
                   Spacer(modifier = Modifier.height(12.dp))
                   Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                      Row(verticalAlignment = Alignment.CenterVertically) {
                         Icon(Icons.Filled.LocalOffer, contentDescription = null, tint = Color(0xFFE5A152), modifier = Modifier.size(16.dp))
                         Spacer(modifier = Modifier.width(8.dp))
                         Text("Offer Discount", fontSize = 14.sp, color = Color(0xFFE5A152), fontWeight = FontWeight.Medium)
                      }
                      Text("-₹$discount", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFFE5A152))
                   }
                }
                
                Spacer(modifier = Modifier.height(20.dp))
                Box(modifier = Modifier.fillMaxWidth().height(1.dp).drawBehind {
                    drawLine(
                        color = Color.LightGray.copy(alpha=0.6f),
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = 2f,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 15f), 0f)
                    )
                })
                Spacer(modifier = Modifier.height(20.dp))
                
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                   Column {
                      Text("Grand Total", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
                      Text("Inclusive of all taxes", fontSize = 12.sp, color = TextLightGrey)
                   }
                   Text("₹$grandTotal", fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, color = DarkCoffeeBrown)
                }
             }
          }
        } // end Bill Details

        // Offers Section
        item {
          Card(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F5F0)),
            elevation = CardDefaults.cardElevation(0.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE5A152).copy(alpha=0.3f))
          ) {
             Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                 Box(modifier = Modifier.size(40.dp).clip(CircleShape).background(Color(0xFFE5A152).copy(alpha=0.1f)), contentAlignment = Alignment.Center) {
                     Icon(Icons.Filled.LocalOffer, contentDescription = null, tint = Color(0xFFE5A152), modifier = Modifier.size(24.dp))
                 }
                 Spacer(modifier = Modifier.width(16.dp))
                 Column(modifier = Modifier.weight(1f)) {
                     Text(
                         text = "10% Off on orders above ₹800",
                         fontWeight = FontWeight.Bold,
                         fontSize = 14.sp,
                         color = DarkCoffeeBrown
                     )
                     Spacer(modifier = Modifier.height(4.dp))
                     Text(
                         text = if (total > 800) "Offer applied successfully!" else "Add ₹${800 - total} more to avail offer",
                         fontSize = 12.sp,
                         color = if (total > 800) Color(0xFF4CAF50) else TextLightGrey
                     )
                 }
             }
          }
        }
      } // end LazyColumn

      // Bottom Bar Checkout
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Color.Transparent)
          .padding(horizontal = 16.dp, vertical = 8.dp)
      ) {
         Box(
            modifier = Modifier
               .fillMaxWidth()
               .height(60.dp)
               .clip(RoundedCornerShape(16.dp))
               .background(DarkCoffeeBrown)
               .clickable { onCheckout() },
            contentAlignment = Alignment.Center
         ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
               Icon(Icons.Filled.LocalMall, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
               Spacer(modifier = Modifier.width(12.dp))
               Text("Proceed to Checkout  •  ₹$grandTotal", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
         }
         Spacer(modifier = Modifier.height(16.dp))
         Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Outlined.LocalPolice, contentDescription = null, tint = TextLightGrey, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("Secure checkout  •  100% safe payments", fontSize = 12.sp, color = TextLightGrey)
         }
         Spacer(modifier = Modifier.height(16.dp))
      }
    }
  }
}

@Composable
fun PaymentScreen(cartItems: List<CartItem>, totalAmount: Int, savedMethods: List<PaymentMethod>, onBackClick: () -> Unit, onPaymentSuccess: () -> Unit) {
  var selectedMethod by remember { mutableStateOf("Card") }
  var paymentState by remember { mutableStateOf("input") } // input, processing, success
  
  var cardNumber by remember { mutableStateOf("") }
  var expiry by remember { mutableStateOf("") }
  var cvv by remember { mutableStateOf("") }
  var cardHolder by remember { mutableStateOf("") }
  
  var upiId by remember { mutableStateOf("") }
  var bankName by remember { mutableStateOf("") }
  var walletName by remember { mutableStateOf("") }
  var walletPhone by remember { mutableStateOf("") }

  LaunchedEffect(paymentState) {
      if (paymentState == "processing") {
          delay(2000)
          paymentState = "success"
      } else if (paymentState == "success") {
          delay(4500) // Enough time to read the receipt
          onPaymentSuccess()
      }
  }

  Box(modifier = Modifier.fillMaxSize()) {
    val scrollState = rememberScrollState()
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(CreamBackground)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(44.dp)
            .shadow(4.dp, CircleShape)
            .clip(CircleShape)
            .background(Color.White)
            .clickable { onBackClick() },
          contentAlignment = Alignment.Center
        ) {
           Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = DarkCoffeeBrown)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text("Secure Checkout", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
      }

      Column(modifier = Modifier.verticalScroll(scrollState).padding(16.dp)) {
          val methods = listOf("Card", "UPI", "Net Banking", "Wallet")
          Row(
              modifier = Modifier.horizontalScroll(rememberScrollState()),
              horizontalArrangement = Arrangement.spacedBy(12.dp)
          ) {
              methods.forEach { method ->
                  val isSelected = selectedMethod == method
                  Box(
                      modifier = Modifier
                          .shadow(if (isSelected) 4.dp else 0.dp, RoundedCornerShape(16.dp))
                          .clip(RoundedCornerShape(16.dp))
                          .background(if (isSelected) DarkCoffeeBrown else Color.White)
                          .clickable { selectedMethod = method }
                          .padding(horizontal = 24.dp, vertical = 12.dp),
                      contentAlignment = Alignment.Center
                  ) {
                      Text(method, color = if (isSelected) Color.White else TextDarkGrid, fontWeight = FontWeight.Bold)
                  }
              }
          }

          Spacer(modifier = Modifier.height(24.dp))

          val relevantMethods = savedMethods.filter { 
             when (selectedMethod) {
                 "Card" -> it is CardPayment
                 "UPI" -> it is UpiPayment
                 "Net Banking" -> it is NetBankingPayment
                 "Wallet" -> it is WalletPayment
                 else -> false
             }
          }
          if (relevantMethods.isNotEmpty()) {
              Text("Use Saved Method", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = TextDarkGrid)
              Spacer(modifier = Modifier.height(8.dp))
              Row(modifier = Modifier.horizontalScroll(rememberScrollState()).padding(bottom = 8.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                  relevantMethods.forEach { method ->
                      Box(modifier = Modifier
                          .border(1.dp, DarkCoffeeBrown.copy(alpha=0.5f), RoundedCornerShape(8.dp))
                          .clip(RoundedCornerShape(8.dp))
                          .background(LightBeige)
                          .clickable {
                          when (method) {
                             is CardPayment -> { cardNumber = method.cardNumber; expiry = method.expiry; cardHolder = "SAVED" }
                             is UpiPayment -> { upiId = method.upiId }
                             is NetBankingPayment -> { bankName = method.bankName }
                             is WalletPayment -> { walletName = method.walletName; walletPhone = method.phoneNumber }
                          }
                      }.padding(16.dp)) {
                           when (method) {
                              is CardPayment -> Text(method.cardNumber, color=DarkCoffeeBrown, fontWeight = FontWeight.Medium)
                              is UpiPayment -> Text(method.upiId, color=DarkCoffeeBrown, fontWeight = FontWeight.Medium)
                              is NetBankingPayment -> Text(method.bankName, color=DarkCoffeeBrown, fontWeight = FontWeight.Medium)
                              is WalletPayment -> Text("${method.walletName} • ${method.phoneNumber}", color=DarkCoffeeBrown, fontWeight = FontWeight.Medium)
                           }
                      }
                  }
              }
              Spacer(modifier = Modifier.height(16.dp))
              Text("Or enter new details:", fontSize = 14.sp, color = TextLightGrey)
              Spacer(modifier = Modifier.height(12.dp))
          }

          if (selectedMethod == "Card") {
              Card(
                  modifier = Modifier.fillMaxWidth().height(200.dp).shadow(8.dp, RoundedCornerShape(16.dp)),
                  shape = RoundedCornerShape(16.dp),
                  colors = CardDefaults.cardColors(containerColor = TextDarkGrid)
              ) {
                  Column(modifier = Modifier.padding(24.dp).fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                      Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                           Text("CREDIT CARD", color = Color.White.copy(alpha=0.7f), letterSpacing = 2.sp, fontWeight = FontWeight.Bold)
                           Icon(Icons.Filled.Check, contentDescription = "Chip", tint = Color.White.copy(alpha=0.8f)) 
                      }
                      Text(
                          text = if (cardNumber.isEmpty()) "#### #### #### ####" else cardNumber.chunked(4).joinToString(" "),
                          color = Color.White,
                          fontSize = 22.sp,
                          letterSpacing = 3.sp,
                          fontFamily = FontFamily.Monospace
                      )
                      Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                           Column {
                               Text("CARDHOLDER", color = Color.White.copy(alpha=0.6f), fontSize = 10.sp, letterSpacing = 1.sp)
                               Text(if (cardHolder.isEmpty()) "YOUR NAME" else cardHolder.uppercase(), color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                           }
                           Column {
                               Text("EXPIRES", color = Color.White.copy(alpha=0.6f), fontSize = 10.sp, letterSpacing = 1.sp)
                               Text(if (expiry.isEmpty()) "MM/YY" else expiry, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                           }
                      }
                  }
              }
              
              Spacer(modifier = Modifier.height(24.dp))
              Text("Card Details", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
              Spacer(modifier = Modifier.height(16.dp))

              OutlinedTextField(
                  value = cardNumber,
                  onValueChange = { if (it.length <= 19) cardNumber = it },
                  label = { Text("Card Number") },
                  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                  modifier = Modifier.fillMaxWidth(),
                  singleLine = true,
                  colors = OutlinedTextFieldDefaults.colors(
                      focusedBorderColor = DarkCoffeeBrown,
                      unfocusedBorderColor = Color.LightGray,
                      focusedLabelColor = DarkCoffeeBrown
                  )
              )
              Spacer(modifier = Modifier.height(16.dp))
              Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                  OutlinedTextField(
                      value = expiry,
                      onValueChange = { if (it.length <= 5) expiry = it },
                      label = { Text("Expiry (MM/YY)") },
                      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                      singleLine = true,
                      modifier = Modifier.weight(1f),
                      colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown, focusedLabelColor = DarkCoffeeBrown, unfocusedBorderColor = Color.LightGray)
                  )
                  OutlinedTextField(
                      value = cvv,
                      onValueChange = { if (it.length <= 3 && it.all { char -> char.isDigit() }) cvv = it },
                      label = { Text("CVV") },
                      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                      singleLine = true,
                      modifier = Modifier.weight(1f),
                      colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown, focusedLabelColor = DarkCoffeeBrown, unfocusedBorderColor = Color.LightGray)
                  )
              }
              Spacer(modifier = Modifier.height(16.dp))
              OutlinedTextField(
                  value = cardHolder,
                  onValueChange = { cardHolder = it },
                  label = { Text("Cardholder Name") },
                  singleLine = true,
                  modifier = Modifier.fillMaxWidth(),
                  colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown, focusedLabelColor = DarkCoffeeBrown, unfocusedBorderColor = Color.LightGray)
              )
          } else if (selectedMethod == "UPI") {
              OutlinedTextField(
                  value = upiId,
                  onValueChange = { upiId = it },
                  label = { Text("Enter UPI ID (e.g., name@bank)") },
                  singleLine = true,
                  modifier = Modifier.fillMaxWidth(),
                  colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown, focusedLabelColor = DarkCoffeeBrown, unfocusedBorderColor = Color.LightGray)
              )
          } else if (selectedMethod == "Net Banking") {
              OutlinedTextField(
                  value = bankName,
                  onValueChange = { bankName = it },
                  label = { Text("Select Bank") },
                  singleLine = true,
                  modifier = Modifier.fillMaxWidth(),
                  colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown, focusedLabelColor = DarkCoffeeBrown, unfocusedBorderColor = Color.LightGray)
              )
          } else if (selectedMethod == "Wallet") {
              OutlinedTextField(
                  value = walletName,
                  onValueChange = { walletName = it },
                  label = { Text("Wallet Name (e.g. Paytm, PhonePe)") },
                  singleLine = true,
                  modifier = Modifier.fillMaxWidth(),
                  colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown, focusedLabelColor = DarkCoffeeBrown, unfocusedBorderColor = Color.LightGray)
              )
              Spacer(modifier = Modifier.height(16.dp))
              OutlinedTextField(
                  value = walletPhone,
                  onValueChange = { walletPhone = it },
                  label = { Text("Phone Number") },
                  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                  singleLine = true,
                  modifier = Modifier.fillMaxWidth(),
                  colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = DarkCoffeeBrown, focusedLabelColor = DarkCoffeeBrown, unfocusedBorderColor = Color.LightGray)
              )
          }
          
          Spacer(modifier = Modifier.height(40.dp))
          
          Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
              Text("Total Amount", fontSize = 16.sp, color = TextLightGrey)
              Text("₹$totalAmount", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
          }
          
          Spacer(modifier = Modifier.height(16.dp))
      
          val isValid = when(selectedMethod) {
              "Card" -> cardNumber.isNotEmpty() && expiry.isNotEmpty() && cardHolder.isNotEmpty() && (cvv.isNotEmpty() || cardHolder == "SAVED")
              "UPI" -> upiId.isNotEmpty() && upiId.contains("@")
              "Net Banking" -> bankName.isNotEmpty()
              "Wallet" -> walletName.isNotEmpty() && walletPhone.isNotEmpty()
              else -> false
          }
          
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .height(56.dp)
              .shadow(if (isValid) 8.dp else 2.dp, RoundedCornerShape(20.dp))
              .clip(RoundedCornerShape(20.dp))
              .background(if (isValid) DarkCoffeeBrown else Color.LightGray)
              .clickable(enabled = isValid) { 
                  paymentState = "processing"
              },
            contentAlignment = Alignment.Center
          ) {
            Text("Pay Now", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
          }
          Spacer(modifier = Modifier.height(30.dp))
      }
    }

    if (paymentState == "processing" || paymentState == "success") {
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.6f)).clickable(enabled=false){},
            contentAlignment = Alignment.Center
        ) {
            if (paymentState == "processing") {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    val infiniteTransition = rememberInfiniteTransition()
                    val offsetY by infiniteTransition.animateFloat(
                        initialValue = -10f, targetValue = 10f,
                        animationSpec = infiniteRepeatable(tween(800), RepeatMode.Reverse),
                        label = "bob"
                    )
                    Icon(Icons.Rounded.LocalCafe, contentDescription = "Processing", tint = CaramelBrown, modifier = Modifier.size(80.dp).offset(y = offsetY.dp))
                    Spacer(modifier = Modifier.height(24.dp))
                    Text("Brewing your order...", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Securely processing payment", color = Color.White.copy(alpha=0.7f), fontSize = 14.sp)
                }
            }

            AnimatedVisibility(
               visible = paymentState == "success",
               enter = fadeIn(tween(500)) + androidx.compose.animation.scaleIn(spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow)),
               exit = androidx.compose.animation.fadeOut(tween(300))
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(0.85f).padding(16.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = LightBeige)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier.size(72.dp).background(DarkCoffeeBrown, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Filled.Coffee, contentDescription = "Success", tint = Color.White, modifier = Modifier.size(40.dp))
                            Box(modifier = Modifier.align(Alignment.BottomEnd).size(24.dp).background(Color.White, CircleShape).padding(2.dp)) {
                                Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = Color(0xFF4CAF50), modifier = Modifier.fillMaxSize())
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("Payment Successful!", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
                        Spacer(modifier = Modifier.height(24.dp))
                        
                        val subtotal = cartItems.sumOf { it.price * it.quantity }
                        val gst = (subtotal * 0.05).toInt()
                        val convenienceFee = 20
                        
                        Column(modifier = Modifier.fillMaxWidth()) {
                            cartItems.forEach { item ->
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    val ext = if (item.extras.isNotEmpty()) " + ${item.extras.joinToString()}" else ""
                                    Text("${item.quantity}x ${item.product.name} (${item.size}$ext)", fontSize = 14.sp, color = TextDarkGrid)
                                    Text("₹${item.price * item.quantity}", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = TextDarkGrid)
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("GST & Taxes", fontSize = 12.sp, color = TextLightGrey)
                                Text("₹$gst", fontSize = 12.sp, color = TextDarkGrid)
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Convenience Fee", fontSize = 12.sp, color = TextLightGrey)
                                Text("₹$convenienceFee", fontSize = 12.sp, color = TextDarkGrid)
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray))
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Total Paid", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
                                Text("₹$totalAmount", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = DarkCoffeeBrown)
                            }
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(DarkCoffeeBrown)
                                .clickable { onPaymentSuccess() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Done", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
  }
}

@Composable
fun WishlistScreen(
    wishlistItems: List<Product>, 
    onToggleWishlist: (Product) -> Unit, 
    onProductClick: (String) -> Unit,
    onBackClick: () -> Unit,
    onAddToCart: (Product) -> Unit = {},
    cartCount: Int = 0,
    onCartClick: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize().background(CreamBackground)) {
        SharedTopBar(
            cartCount = cartCount,
            onCartClick = onCartClick,
            onMenuClick = { },
            containerColor = Color.Black
        )

        if (wishlistItems.isEmpty()) {
            Box(modifier = Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text("Your wishlist is empty", fontSize = 16.sp, color = TextLightGrey)
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 100.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(wishlistItems, key = { _, item -> item.id }) { index, product ->
                    AnimatedProductCard(
                        product = product, 
                        index = index,
                        isVisible = true,
                        isFavorite = true, 
                        onToggleFavorite = { onToggleWishlist(product) },
                        onClick = { onProductClick(product.id) },
                        onAddToCart = { onAddToCart(product) }
                    )
                }
            }
        }
    }
}

@Composable
fun CatalogScreen(isVegOnly: Boolean = false, wishlistItems: List<Product>, onToggleWishlist: (Product) -> Unit, onAddToCart: (CartItem) -> Unit, cartCount: Int = 0, onCartClick: () -> Unit = {}, onProductClick: (String) -> Unit = {}, onBackClick: () -> Unit = {}) {
  var searchQuery by remember { mutableStateOf("") }
  var showFilters by remember { mutableStateOf(false) }
  var selectedCategory by remember { mutableStateOf("All") }
  var selectedRoast by remember { mutableStateOf("All") }
  var isVisible by remember { mutableStateOf(false) }

  val catalogCategories = listOf("All", "Hot Coffee", "Cold Coffee", "Tea", "Signature", "Bakery", "Dessert", "Snacks", "Refreshers")
  val roastProfiles = listOf("All", "Light Roast", "Medium Roast", "Dark Roast")

  val filteredProducts = remember(searchQuery, selectedCategory, selectedRoast, isVegOnly) {
     sampleProducts.filter { 
         (searchQuery.isEmpty() || it.name.contains(searchQuery, ignoreCase = true)) &&
         (selectedCategory == "All" || it.category == selectedCategory) &&
         (selectedRoast == "All" || (it.roastProfile ?: "All") == selectedRoast) &&
         (!isVegOnly || it.isVeg)
     }
  }

  LaunchedEffect(Unit) {
    isVisible = true
  }

  Column(modifier = Modifier.fillMaxSize().background(CreamBackground)) {
    // Header
    SharedTopBar(
        cartCount = cartCount,
        onCartClick = onCartClick,
        onMenuClick = onBackClick,
        containerColor = Color.Black,
        showBackIcon = true
    )

    // Search Bar
    SearchSection(
        searchQuery = searchQuery, 
        onQueryChange = { searchQuery = it },
        onFilterClick = { showFilters = true }
    )
    
    Spacer(modifier = Modifier.height(12.dp))

    // Grid
    LazyVerticalGrid(
      columns = GridCells.Fixed(2),
      contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 100.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      modifier = Modifier.fillMaxSize()
    ) {
      itemsIndexed(filteredProducts, key = { _, item -> item.id }) { index, product ->
        AnimatedProductCard(
             product = product,
             index = index,
             isVisible = isVisible,
             isFavorite = wishlistItems.contains(product),
             onToggleFavorite = { onToggleWishlist(product) },
             onClick = { onProductClick(product.id) },
             onAddToCart = { 
                 onAddToCart(CartItem(product = product, size = "Standard", price = product.price.replace("₹", "").trim().toIntOrNull() ?: 99, quantity = 1)) 
             }
        )
      }
    }
  }

  if (showFilters) {
      @OptIn(ExperimentalMaterial3Api::class)
      ModalBottomSheet(
          onDismissRequest = { showFilters = false },
          containerColor = LightBeige
      ) {
          Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 32.dp)) {
              Text("Filters", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TextDarkGrid)
              Spacer(modifier = Modifier.height(16.dp))
              
              Text("Categories", fontWeight = FontWeight.Bold, color = TextDarkGrid, fontSize = 14.sp)
              Spacer(modifier = Modifier.height(8.dp))
              Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                  catalogCategories.forEach { category ->
                      CustomChip(
                          text = category, 
                          isSelected = selectedCategory == category, 
                          onClick = { selectedCategory = category; if(category != "Beans") selectedRoast = "All" }
                      )
                  }
              }
              
              Spacer(modifier = Modifier.height(24.dp))
              
              AnimatedVisibility(visible = selectedCategory == "All" || selectedCategory == "Beans") {
                  Column {
                      Text("Roast Profile", fontWeight = FontWeight.Bold, color = TextDarkGrid, fontSize = 14.sp)
                      Spacer(modifier = Modifier.height(8.dp))
                      Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                          roastProfiles.forEach { roast ->
                              CustomChip(
                                  text = roast, 
                                  isSelected = selectedRoast == roast, 
                                  onClick = { selectedRoast = roast }
                              )
                          }
                      }
                      Spacer(modifier = Modifier.height(16.dp))
                  }
              }
              Spacer(modifier = Modifier.height(16.dp))
          }
      }
  }
}

@Composable
fun CustomChip(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(if (isSelected) DarkCoffeeBrown else CreamBackground)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else TextDarkGrid,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }
}


@Composable
fun ShimmerProductCard() {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .shadow(6.dp, RoundedCornerShape(20.dp)),
    shape = RoundedCornerShape(20.dp),
    colors = CardDefaults.cardColors(containerColor = LightBeige)
  ) {
    Column(
      modifier = Modifier.padding(12.dp)
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .aspectRatio(1f)
          .clip(RoundedCornerShape(16.dp))
          .shimmerEffect()
      )

      Spacer(modifier = Modifier.height(12.dp))

      Box(modifier = Modifier.height(16.dp).fillMaxWidth(0.8f).clip(RoundedCornerShape(4.dp)).shimmerEffect())
      Spacer(modifier = Modifier.height(4.dp))
      Box(modifier = Modifier.height(12.dp).fillMaxWidth(0.6f).clip(RoundedCornerShape(4.dp)).shimmerEffect())
      
      Spacer(modifier = Modifier.height(8.dp))

      Box(modifier = Modifier.height(12.dp).width(40.dp).clip(RoundedCornerShape(4.dp)).shimmerEffect())

      Spacer(modifier = Modifier.height(12.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(modifier = Modifier.height(16.dp).width(50.dp).clip(RoundedCornerShape(4.dp)).shimmerEffect())
        Box(modifier = Modifier.size(28.dp).clip(CircleShape).shimmerEffect())
      }
    }
  }
}

@Composable
fun ShimmerProductDetailScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(CreamBackground)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(350.dp)
        .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
        .shimmerEffect()
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 40.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(modifier = Modifier.size(44.dp).clip(CircleShape).shimmerEffect())
        Box(modifier = Modifier.size(44.dp).clip(CircleShape).shimmerEffect())
      }
    }
    
    Column(modifier = Modifier.padding(24.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(modifier = Modifier.weight(1f)) {
          Box(modifier = Modifier.height(24.dp).fillMaxWidth(0.6f).clip(RoundedCornerShape(4.dp)).shimmerEffect())
          Spacer(modifier = Modifier.height(8.dp))
          Box(modifier = Modifier.height(14.dp).fillMaxWidth(0.4f).clip(RoundedCornerShape(4.dp)).shimmerEffect())
        }
        Box(modifier = Modifier.width(40.dp).height(20.dp).clip(RoundedCornerShape(4.dp)).shimmerEffect())
      }

      Spacer(modifier = Modifier.height(24.dp))

      Box(modifier = Modifier.height(18.dp).fillMaxWidth(0.3f).clip(RoundedCornerShape(4.dp)).shimmerEffect())
      Spacer(modifier = Modifier.height(12.dp))
      Box(modifier = Modifier.height(14.dp).fillMaxWidth(0.9f).clip(RoundedCornerShape(4.dp)).shimmerEffect())
      Spacer(modifier = Modifier.height(4.dp))
      Box(modifier = Modifier.height(14.dp).fillMaxWidth(0.8f).clip(RoundedCornerShape(4.dp)).shimmerEffect())
      Spacer(modifier = Modifier.height(4.dp))
      Box(modifier = Modifier.height(14.dp).fillMaxWidth(0.5f).clip(RoundedCornerShape(4.dp)).shimmerEffect())

      Spacer(modifier = Modifier.height(24.dp))

      Box(modifier = Modifier.height(18.dp).fillMaxWidth(0.2f).clip(RoundedCornerShape(4.dp)).shimmerEffect())
      Spacer(modifier = Modifier.height(12.dp))
      
      Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        repeat(3) {
          Box(modifier = Modifier.weight(1f).height(48.dp).clip(RoundedCornerShape(16.dp)).shimmerEffect())
        }
      }

      Spacer(modifier = Modifier.height(40.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Box(modifier = Modifier.height(14.dp).width(60.dp).clip(RoundedCornerShape(4.dp)).shimmerEffect())
          Spacer(modifier = Modifier.height(4.dp))
          Box(modifier = Modifier.height(24.dp).width(80.dp).clip(RoundedCornerShape(4.dp)).shimmerEffect())
        }
        
        Row(
          modifier = Modifier.weight(1f).padding(start = 24.dp),
          horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          Box(modifier = Modifier.size(56.dp).clip(RoundedCornerShape(16.dp)).shimmerEffect())
          Box(modifier = Modifier.weight(1f).height(56.dp).clip(RoundedCornerShape(20.dp)).shimmerEffect())
        }
      }
    }
  }
}

@Composable
fun OrderHistoryScreen(orders: List<Order>, onBackClick: () -> Unit) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(CreamBackground)
  ) {
    // Top Bar
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .padding(horizontal = 16.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(44.dp)
          .shadow(4.dp, CircleShape)
          .clip(CircleShape)
          .background(Color.White)
          .clickable { onBackClick() },
        contentAlignment = Alignment.Center
      ) {
        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = DarkCoffeeBrown)
      }
      Text(
        text = "Order History",
        modifier = Modifier.padding(start = 16.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = TextDarkGrid
      )
    }

    if (orders.isEmpty()) {
       Box(modifier = Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
           Text("No orders yet", fontSize = 16.sp, color = TextLightGrey)
       }
    } else {
        LazyColumn(
          contentPadding = PaddingValues(16.dp),
          verticalArrangement = Arrangement.spacedBy(16.dp),
          modifier = Modifier.weight(1f)
        ) {
          items(orders, key = { it.id }) { order ->
            OrderCard(order)
          }
        }
    }
  }
}

@Composable
fun OrderCard(order: Order) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .shadow(4.dp, RoundedCornerShape(16.dp)),
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = LightBeige)
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(text = "Order ${order.id}", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TextDarkGrid)
        Text(text = "₹${order.total}", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = DarkCoffeeBrown)
      }
      Spacer(modifier = Modifier.height(8.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(text = order.date, fontSize = 14.sp, color = TextLightGrey)
        Text(
            text = order.status, 
            fontSize = 14.sp, 
            fontWeight = FontWeight.SemiBold, 
            color = if(order.status == "Delivered") Color(0xFF4CAF50) else Color(0xFFFF9800)
        )
      }
      Spacer(modifier = Modifier.height(16.dp))
      Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray.copy(alpha = 0.5f)))
      Spacer(modifier = Modifier.height(16.dp))
      Text(text = "Items:", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = TextDarkGrid)
      Spacer(modifier = Modifier.height(8.dp))
      order.items.forEach { item ->
         Row(
             modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
             horizontalArrangement = Arrangement.SpaceBetween
         ) {
             val ext = if (item.extras.isNotEmpty()) " + ${item.extras.joinToString()}" else ""
             Text(text = "${item.quantity}x ${item.product.name} (${item.size}$ext)", fontSize = 14.sp, color = TextDarkGrid)
         }
      }
    }
  }
}

@Composable
fun CartIconButton(cartCount: Int, onCartClick: () -> Unit, containerColor: Color = Color.Black.copy(alpha = 0.5f)) {
    val scale = remember { androidx.compose.animation.core.Animatable(1f) }
    LaunchedEffect(cartCount) {
        if (cartCount > 0) {
            scale.animateTo(1.3f, animationSpec = tween(150))
            scale.animateTo(1f, animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow))
        }
    }
    
    IconButton(onClick = onCartClick) {
        Box(contentAlignment = Alignment.Center) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(containerColor)
                    .border(1.dp, Color.LightGray.copy(alpha = 0.3f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Outlined.ShoppingBag, contentDescription = "Cart", tint = Color.White, modifier = Modifier.size(18.dp))
            }
            if (cartCount > 0) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(18.dp)
                        .scale(scale.value)
                        .clip(CircleShape)
                        .background(Color(0xFFE5A152)), // Orange/Caramel
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = cartCount.toString(), color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun SharedTopBar(cartCount: Int, onCartClick: () -> Unit, onMenuClick: () -> Unit, containerColor: Color = Color.Transparent, showBackIcon: Boolean = false) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .background(containerColor)
      .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 12.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Box(
      modifier = Modifier
        .size(44.dp)
        .clip(CircleShape)
        .background(Color.Black.copy(alpha = 0.5f))
        .border(1.dp, Color.LightGray.copy(alpha = 0.3f), CircleShape)
        .clickable { onMenuClick() },
      contentAlignment = Alignment.Center
    ) {
      Icon(
        imageVector = if (showBackIcon) Icons.AutoMirrored.Filled.ArrowBack else Icons.Filled.Menu,
        contentDescription = if (showBackIcon) "Back" else "Menu",
        tint = Color.White,
        modifier = Modifier.size(18.dp)
      )
    }
    
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
       AurumLogo(size = 28.dp)
       Spacer(modifier = Modifier.height(4.dp))
       Text("AURUM", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = LightBeige, letterSpacing = 2.sp)
       Text("— CAFÉ —", fontSize = 10.sp, color = LightBeige.copy(alpha = 0.8f), letterSpacing = 2.sp)
    }
    
    CartIconButton(cartCount = cartCount, onCartClick = onCartClick)
  }
}

@Preview(showBackground = true)
@Composable
fun CoffeeHomeScreenPreview() {
  MyApplicationTheme {
    CoffeeHomeScreen(wishlistItems = emptyList(), onToggleWishlist = {})
  }
}

fun Modifier.shimmerEffect(): Modifier = composed {
  var size by remember { mutableStateOf(androidx.compose.ui.unit.IntSize.Zero) }
  val transition = rememberInfiniteTransition(label = "shimmer")
  val startOffsetX by transition.animateFloat(
    initialValue = -2 * size.width.toFloat(),
    targetValue = 2 * size.width.toFloat(),
    animationSpec = infiniteRepeatable(
      animation = tween(1000)
    ),
    label = "shimmer_offset"
  )

  background(
    brush = Brush.linearGradient(
      colors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
      ),
      start = Offset(startOffsetX, 0f),
      end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
    )
  ).onGloballyPositioned { size = it.size }
}


val WaveShape = androidx.compose.foundation.shape.GenericShape { size, _ ->
    moveTo(0f, 60f)
    quadraticTo(size.width / 3f, 0f, size.width / 2f, 40f)
    quadraticTo(size.width * 2/3f, 80f, size.width, 20f)
    lineTo(size.width, size.height)
    lineTo(0f, size.height)
    close()
}

data class AppCustomOption(val name: String, val price: Int)
data class AppCustomGroup(val title: String, val subtitle: String, val icon: androidx.compose.ui.graphics.vector.ImageVector, val options: List<AppCustomOption>)

@OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)
@Composable
fun NewProductDetailScreen(
  product: Product,
  wishlistItems: List<Product>,
  onToggleWishlist: () -> Unit,
  onBackClick: () -> Unit,
  onProceedToCheckout: (CartItem) -> Unit
) {
    val creamBg = Color(0xFFF8F4EC)
    val darkBrown = Color(0xFF2C211B)
    val cardBrown = Color(0xFF423328)
    val goldAccent = Color(0xFFF0B86F)
    val textPrimary = Color(0xFF332A24)
    val textMuted = Color(0xFF8B8276)
    val surfaceStroke = Color(0xFFEBE3D8)
    val goldGradient = Brush.horizontalGradient(listOf(Color(0xFFFAD9A1), Color(0xFFEFB972)))

    val scrollState = rememberScrollState()
    val isFavorite = wishlistItems.contains(product)
    val haptic = LocalHapticFeedback.current

    val basePrice = product.price.replace("₹", "").toIntOrNull() ?: 199

    val groups = remember(product) {
        val g = mutableListOf<AppCustomGroup>()
        val isCoffee = product.category.contains("Coffee")
        val isTea = product.category.contains("Tea")
        val isBakery = product.category.contains("Bakery") || product.category.contains("Dessert")
        val isFood = product.name.contains("Sandwich") || product.name.contains("Panini") || product.name.contains("Toast")
        
        if (isCoffee || isTea || (!isBakery && !isFood)) {
            g.add(AppCustomGroup("Size", "Choose your perfect size", Icons.Outlined.LocalCafe, listOf(
                AppCustomOption("Small", basePrice - 50), AppCustomOption("Medium", basePrice), AppCustomOption("Large", basePrice + 50)
            )))
            if (isCoffee) {
                g.add(AppCustomGroup("Milk Choice", "Select your preferred milk", Icons.Outlined.WaterDrop, listOf(
                    AppCustomOption("Whole Milk", 0), AppCustomOption("Skim Milk", 0), AppCustomOption("Oat Milk", 30), AppCustomOption("Almond Milk", 30)
                )))
            }
            g.add(AppCustomGroup("Sugar Level", "Adjust the sweetness", Icons.Outlined.FilterBAndW, listOf(
                AppCustomOption("No Sugar", 0), AppCustomOption("Low", 0), AppCustomOption("Regular", 0), AppCustomOption("Extra", 0)
            )))
            if (isCoffee) {
                g.add(AppCustomGroup("Extra Espresso", "Make it stronger", Icons.Outlined.LocalFireDepartment, listOf(
                    AppCustomOption("None", 0), AppCustomOption("Single Shot", 25), AppCustomOption("Double Shot", 45)
                )))
                g.add(AppCustomGroup("Foam Preference", "Choose your foam texture", Icons.Filled.Coffee, listOf(
                    AppCustomOption("Less Foam", 0), AppCustomOption("Regular Foam", 0), AppCustomOption("Extra Foam", 0)
                )))
            }
        } else if (isBakery) {
            g.add(AppCustomGroup("Serving Style", "How would you like it?", Icons.Filled.LocalMall, listOf(
                AppCustomOption("Regular", basePrice), AppCustomOption("Warmed Up", basePrice)
            )))
            g.add(AppCustomGroup("Ice Cream Pairing", "Add a scoop", Icons.Outlined.LocalCafe, listOf(
                AppCustomOption("None", 0), AppCustomOption("Vanilla Scoop", 60), AppCustomOption("Chocolate Scoop", 60)
            )))
        } else if (isFood) {
            g.add(AppCustomGroup("Bread Type", "Choose your bread", Icons.Filled.BakeryDining, listOf(
                AppCustomOption("White", basePrice), AppCustomOption("Whole Wheat", basePrice), AppCustomOption("Sourdough", basePrice + 30)
            )))
            g.add(AppCustomGroup("Extras", "Add more flavor", Icons.Filled.Add, listOf(
                AppCustomOption("None", 0), AppCustomOption("Extra Cheese", 30), AppCustomOption("Extra Protein", 60)
            )))
        }
        g
    }

    var selections by remember(product.id) {
        val initialSelections = mutableMapOf<String, AppCustomOption>()
        groups.forEach { group ->
            val defaultOption = group.options.firstOrNull { 
                it.name.contains("Medium") || it.name.contains("Whole") || it.name.contains("Regular") || it.name.contains("None") || it.name.contains("White") 
            } ?: group.options.first()
            initialSelections[group.title] = defaultOption
        }
        mutableStateOf(initialSelections)
    }

    var quantity by remember { mutableStateOf(1) }
    val animatedQuantity by androidx.compose.animation.core.animateIntAsState(
        targetValue = quantity, 
        animationSpec = androidx.compose.animation.core.spring(stiffness = androidx.compose.animation.core.Spring.StiffnessLow)
    )

    val baseGroupName = groups.firstOrNull()?.title ?: "Size"
    val baseSizePrice = selections[baseGroupName]?.price ?: basePrice
    val extrasCost = selections.entries.filter { it.key != baseGroupName }.sumOf { it.value.price }
    val totalPrice = (baseSizePrice + extrasCost) * quantity

    val animTotalPrice by androidx.compose.animation.core.animateIntAsState(
        targetValue = totalPrice, 
        animationSpec = androidx.compose.animation.core.spring(stiffness = androidx.compose.animation.core.Spring.StiffnessLow)
    )

    var loaded by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { loaded = true }
    val imageScale by androidx.compose.animation.core.animateFloatAsState(
        targetValue = if (loaded) 1.05f else 0.9f, 
        animationSpec = androidx.compose.animation.core.spring(dampingRatio = 0.7f, stiffness = 100f)
    )
    val imageOffset = (scrollState.value * 0.4f).coerceAtMost(300f)

    Box(modifier = Modifier.fillMaxSize().background(creamBg)) {
        Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {
            // HERO IMAGE
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
                    .graphicsLayer { translationY = imageOffset }
            ) {
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = product.name,
                    modifier = Modifier.fillMaxSize().graphicsLayer { scaleX = imageScale; scaleY = imageScale },
                    contentScale = ContentScale.Crop
                )
                // Bottom Fade overlay to blend image into the dark card
                Box(modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth().height(160.dp).background(Brush.verticalGradient(
                    colors = listOf(Color.Transparent, darkBrown)
                )))
            }

            // DARK INFO CARD
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-1).dp) // seamless transition
                    .background(darkBrown)
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 32.dp)
            ) {
                Text(text = product.name, fontSize = 34.sp, fontWeight = FontWeight.Bold, color = creamBg, lineHeight = 38.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.Star, contentDescription = "Rating", tint = goldAccent, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "${product.rating} (230)  •  ${product.category}", fontSize = 15.sp, color = creamBg.copy(alpha=0.7f))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "A perfect balance of bold espresso, steamed milk, and a silky layer of foam.",
                    fontSize = 15.sp,
                    color = creamBg.copy(alpha = 0.8f),
                    lineHeight = 24.sp
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    val pillBg = Color(0xFF3C2C21) // slightly lighter than dark brown
                    Row(modifier = Modifier.background(pillBg, RoundedCornerShape(12.dp)).padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.Star, contentDescription = "Best Seller", tint = goldAccent, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Best Seller", fontSize = 13.sp, color = goldAccent, fontWeight = FontWeight.Medium)
                    }
                    if (product.category.contains("Coffee")) {
                        Row(modifier = Modifier.background(pillBg, RoundedCornerShape(12.dp)).padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.Coffee, contentDescription = "Barista Choice", tint = goldAccent, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Barista Choice", fontSize = 13.sp, color = goldAccent, fontWeight = FontWeight.Medium)
                        }
                    }
                    Row(modifier = Modifier.background(pillBg, RoundedCornerShape(12.dp)).padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.Tune, contentDescription = "Customizable", tint = goldAccent, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Customizable", fontSize = 13.sp, color = goldAccent, fontWeight = FontWeight.Medium)
                    }
                }
            }

            // CREAM SECTION - CUSTOMIZATIONS
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(creamBg)
                    .padding(vertical = 32.dp, horizontal = 24.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Customizations", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = textPrimary)
                    Row(modifier = Modifier.clickable { 
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        val initialSelections = mutableMapOf<String, AppCustomOption>()
                        groups.forEach { group ->
                            val defaultOption = group.options.firstOrNull { it.name.contains("Medium") || it.name.contains("Whole") || it.name.contains("Regular") || it.name.contains("None") || it.name.contains("White") } ?: group.options.first()
                            initialSelections[group.title] = defaultOption
                        }
                        selections = initialSelections
                    }, verticalAlignment = Alignment.CenterVertically) {
                        Text("Reset", fontSize = 14.sp, color = goldAccent, fontWeight = FontWeight.SemiBold)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.Outlined.Close, contentDescription = "Reset", tint = goldAccent, modifier = Modifier.size(16.dp))
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))

                groups.forEach { group ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(group.icon, contentDescription = null, tint = textPrimary, modifier = Modifier.size(22.dp))
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(group.title, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = textPrimary)
                            Text(group.subtitle, fontSize = 13.sp, color = textMuted)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    if (group.options.size <= 3) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            group.options.forEach { opt ->
                                val isSelected = selections[group.title] == opt
                                val animBg by androidx.compose.animation.animateColorAsState(if(isSelected) cardBrown else Color.White)
                                val animText by androidx.compose.animation.animateColorAsState(if(isSelected) creamBg else textPrimary)
                                val animStroke by androidx.compose.animation.animateColorAsState(if(isSelected) cardBrown else surfaceStroke)
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(16.dp))
                                        .background(animBg)
                                        .border(1.dp, animStroke, RoundedCornerShape(16.dp))
                                        .clickable { 
                                            selections = selections.toMutableMap().apply { put(group.title, opt) }
                                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                        }
                                        .padding(vertical = 16.dp, horizontal = 8.dp)
                                ) {
                                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                                        Text(opt.name, fontSize = 14.sp, fontWeight = if(isSelected) FontWeight.Bold else FontWeight.Medium, color = animText)
                                        Spacer(modifier = Modifier.height(4.dp))
                                        if (group.title == baseGroupName || opt.price > 0) {
                                            Text(if(group.title == baseGroupName) "₹${opt.price}" else "+₹${opt.price}", fontSize = 12.sp, color = if(isSelected) goldAccent else textMuted)
                                        } else {
                                            Text(" ", fontSize = 12.sp) // keep alignment
                                        }
                                    }
                                    if (isSelected) {
                                        Box(modifier = Modifier.align(Alignment.BottomEnd).offset(x=(-8).dp, y=(-8).dp).size(20.dp).background(goldAccent, CircleShape), contentAlignment = Alignment.Center) {
                                            Icon(Icons.Filled.Check, contentDescription = null, tint = darkBrown, modifier = Modifier.size(12.dp))
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            group.options.forEach { opt ->
                                val isSelected = selections[group.title] == opt
                                val animBg by androidx.compose.animation.animateColorAsState(if(isSelected) cardBrown else Color.White)
                                val animText by androidx.compose.animation.animateColorAsState(if(isSelected) creamBg else textPrimary)
                                val animStroke by androidx.compose.animation.animateColorAsState(if(isSelected) cardBrown else surfaceStroke)
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(16.dp))
                                        .background(animBg)
                                        .border(1.dp, animStroke, RoundedCornerShape(16.dp))
                                        .clickable { 
                                            selections = selections.toMutableMap().apply { put(group.title, opt) }
                                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                        }
                                        .padding(vertical = 16.dp, horizontal = 24.dp)
                                ) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Text(opt.name, fontSize = 14.sp, fontWeight = if(isSelected) FontWeight.Bold else FontWeight.Medium, color = animText)
                                        Spacer(modifier = Modifier.height(4.dp))
                                        if (group.title == baseGroupName || opt.price > 0) {
                                            Text(if(group.title == baseGroupName) "₹${opt.price}" else "+₹${opt.price}", fontSize = 12.sp, color = if(isSelected) goldAccent else textMuted)
                                        } else {
                                            Text(" ", fontSize = 12.sp) // space
                                        }
                                    }
                                    if (isSelected) {
                                        Box(modifier = Modifier.align(Alignment.BottomEnd).offset(x=(14).dp, y=(6).dp).size(18.dp).background(goldAccent, CircleShape), contentAlignment = Alignment.Center) {
                                            Icon(Icons.Filled.Check, contentDescription = null, tint = darkBrown, modifier = Modifier.size(12.dp))
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                }

                // PRODUCT HIGHLIGHTS
                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.Eco, contentDescription = null, tint = goldAccent, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Product Highlights", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = textPrimary)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(24.dp)).background(Color.White).padding(16.dp)) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.Top) {
                            Icon(Icons.Outlined.Eco, contentDescription = null, tint = textPrimary, modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("100% Arabica", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = textPrimary)
                                Text("Premium beans", fontSize = 11.sp, color = textMuted)
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.Top) {
                            Icon(Icons.Outlined.LocalFireDepartment, contentDescription = null, tint = textPrimary, modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("Freshly Brewed", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = textPrimary)
                                Text("Every cup", fontSize = 11.sp, color = textMuted)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.Top) {
                            Icon(Icons.Outlined.VerifiedUser, contentDescription = null, tint = textPrimary, modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("Premium Ingredients", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = textPrimary)
                                Text("Finest quality", fontSize = 11.sp, color = textMuted)
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.Top) {
                            Icon(Icons.Filled.FavoriteBorder, contentDescription = null, tint = textPrimary, modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("Handcrafted", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = textPrimary)
                                Text("By expert baristas", fontSize = 11.sp, color = textMuted)
                            }
                        }
                    }
                }

                // YOU MAY ALSO LIKE
                Spacer(modifier = Modifier.height(40.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("You May Also Like", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = textPrimary)
                }
                Spacer(modifier = Modifier.height(16.dp))
                val related = remember(product) { sampleProducts.filter { it.category == product.category && it.id != product.id }.take(3) }
                Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    related.forEach { rel ->
                        Column(modifier = Modifier.width(150.dp).clip(RoundedCornerShape(20.dp)).background(Color.White).padding(8.dp).padding(bottom = 8.dp)) {
                            Box(modifier = Modifier.height(130.dp).fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(creamBg)) {
                                Image(painter = painterResource(rel.imageRes), contentDescription = rel.name, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                                Box(modifier = Modifier.align(Alignment.TopEnd).padding(8.dp).size(28.dp).background(darkBrown.copy(alpha=0.3f), CircleShape), contentAlignment = Alignment.Center) {
                                    Icon(Icons.Filled.FavoriteBorder, contentDescription = null, tint = creamBg, modifier = Modifier.size(16.dp))
                                }
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(rel.name, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = textPrimary, maxLines=1, modifier = Modifier.padding(horizontal=4.dp))
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(modifier = Modifier.fillMaxWidth().padding(horizontal=4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                                Text(rel.price, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = textPrimary)
                                Box(modifier = Modifier.size(24.dp).background(darkBrown, CircleShape), contentAlignment = Alignment.Center) {
                                    Icon(Icons.Filled.Add, contentDescription = "Add", tint = creamBg, modifier = Modifier.size(14.dp))
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
            } // end cream section

            // YOUR SELECTION (DARK STICKY-LIKE BOTTOM CARD)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(darkBrown)
                    .padding(24.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Your Selection", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = creamBg)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Edit", fontSize = 14.sp, color = goldAccent)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.Filled.Edit, contentDescription = null, tint = goldAccent, modifier = Modifier.size(14.dp))
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))

                groups.forEach { group ->
                    val opt = selections[group.title] ?: group.options.first()
                    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(group.icon, contentDescription = null, tint = creamBg.copy(alpha=0.6f), modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(group.title, fontSize = 13.sp, color = creamBg.copy(alpha=0.6f))
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(opt.name, fontSize = 15.sp, color = creamBg, fontWeight = FontWeight.Medium)
                            }
                        }
                        if (group.title == baseGroupName) {
                            Text("₹${opt.price}", fontSize = 15.sp, color = creamBg, fontWeight = FontWeight.SemiBold)
                        } else {
                            Text(if (opt.price > 0) "+₹${opt.price}" else "Included", fontSize = 14.sp, color = if(opt.price > 0) creamBg else creamBg.copy(alpha=0.6f), fontWeight = if(opt.price>0) FontWeight.SemiBold else FontWeight.Normal)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                // Gold Points Pill
                Row(
                    modifier = Modifier.fillMaxWidth().background(cardBrown, RoundedCornerShape(16.dp)).padding(horizontal = 16.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.size(24.dp).background(goldAccent, CircleShape), contentAlignment = Alignment.Center) {
                        Icon(Icons.Filled.Star, contentDescription = "Points", tint = darkBrown, modifier = Modifier.size(14.dp))
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    val earn = (totalPrice * 0.1).toInt()
                    Text("You'll earn ", fontSize = 14.sp, color = creamBg)
                    Text("$earn points", fontSize = 14.sp, color = goldAccent, fontWeight = FontWeight.Bold)
                    Text(" with this order", fontSize = 14.sp, color = creamBg)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(Icons.Outlined.Info, contentDescription = null, tint = creamBg.copy(alpha=0.6f), modifier = Modifier.size(16.dp))
                }

                Spacer(modifier = Modifier.height(32.dp))
                
                // Quantity and Total Price
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Row(
                        modifier = Modifier.background(Color(0xFF3C2C21), RoundedCornerShape(30.dp)).padding(horizontal = 20.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Filled.Remove, contentDescription = "Decrease", tint = creamBg.copy(alpha=0.6f), modifier = Modifier.size(20.dp).clickable{ if(quantity>1){quantity--; haptic.performHapticFeedback(HapticFeedbackType.LongPress)}})
                        Spacer(modifier = Modifier.width(24.dp))
                        Text("$animatedQuantity", fontSize = 18.sp, color = creamBg, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(24.dp))
                        Icon(Icons.Filled.Add, contentDescription = "Increase", tint = creamBg.copy(alpha=0.6f), modifier = Modifier.size(20.dp).clickable{ quantity++; haptic.performHapticFeedback(HapticFeedbackType.LongPress)})
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text("Total Price", fontSize = 13.sp, color = creamBg.copy(alpha=0.6f))
                        Spacer(modifier = Modifier.height(2.dp))
                        Text("₹$animTotalPrice", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = creamBg)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Add to cart button
                Button(
                    onClick = { 
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        val extrasList = selections.entries.filter{it.key != baseGroupName}.map { "${it.key}: ${it.value.name}" }
                        onProceedToCheckout(CartItem(product = product, size = selections[baseGroupName]?.name ?: "Regular", price = totalPrice / quantity, quantity = quantity, extras = extrasList))
                    },
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize().background(goldGradient), contentAlignment = Alignment.Center) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Outlined.ShoppingBag, contentDescription = null, tint = darkBrown, modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(12.dp))
                            Text("Add to Cart", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = darkBrown)
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(Icons.Filled.Star, contentDescription = "Sparkle", tint = darkBrown, modifier = Modifier.size(16.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.Info, contentDescription = null, tint = creamBg.copy(alpha=0.5f), modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Secure & Safe Payments", fontSize = 13.sp, color = creamBg.copy(alpha=0.5f))
                }
                Spacer(modifier = Modifier.height(40.dp)) // bottom generous padding
            }
        } // end main scroll column

        // TOP BAR (Absolute)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(44.dp).background(Color.Black.copy(alpha=0.4f), CircleShape).border(1.dp, Color.White.copy(alpha=0.1f), CircleShape).clickable { onBackClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Box(
                modifier = Modifier.size(44.dp).background(Color.White, CircleShape).clickable { 
                    onToggleWishlist()
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                contentAlignment = Alignment.Center
            ) {
                val iconScale by androidx.compose.animation.core.animateFloatAsState(targetValue = if (isFavorite) 1.2f else 1f)
                Icon(
                    if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = if (isFavorite) Color(0xFFFF3B30) else darkBrown, 
                    modifier = Modifier.graphicsLayer { scaleX = iconScale; scaleY = iconScale }.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun AurumSpecialScreen(specialItems: List<Product>, onProductClick: (String) -> Unit, cartCount: Int, onCartClick: () -> Unit, onBackClick: () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { isVisible = true }
    val scrollState = rememberScrollState()
    
    val alphaAnim by animateFloatAsState(targetValue = if (isVisible) 1f else 0f, animationSpec = tween(1200, easing = androidx.compose.animation.core.FastOutSlowInEasing))
    val slideAnim by androidx.compose.animation.core.animateDpAsState(targetValue = if (isVisible) 0.dp else 40.dp, animationSpec = tween(1200, easing = androidx.compose.animation.core.FastOutSlowInEasing))

    Box(modifier = Modifier.fillMaxSize().background(
        Brush.verticalGradient(
            colors = listOf(Color(0xFF1E1714), Color.Black)
        )
    )) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Elegant Back Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.1f))
                        .border(1.dp, Color(0xFFD4AF37).copy(alpha = 0.4f), CircleShape)
                        .clickable { onBackClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xFFD4AF37))
                }
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.1f))
                        .border(1.dp, Color(0xFFD4AF37).copy(alpha = 0.4f), CircleShape)
                        .clickable { onCartClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Filled.AddShoppingCart, contentDescription = "Cart", tint = Color(0xFFD4AF37), modifier = Modifier.size(20.dp))
                    if (cartCount > 0) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .offset(x = 4.dp, y = (-4).dp)
                                .size(18.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFD4AF37)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = cartCount.toString(), color = Color.Black, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            // Pinterest style staggered grid with animation
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .verticalScroll(scrollState)
                    .alpha(alphaAnim)
                    .offset(y = slideAnim)
            ) {
                Text(
                    "A U R U M  R E S E R V E",
                    color = Color(0xFFD4AF37),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.padding(vertical = 16.dp),
                    fontFamily = FontFamily.Serif
                )
                Text(
                    "Exclusive selections crafted for perfection.",
                    color = Color(0xFFD4AF37).copy(alpha = 0.7f),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 24.dp),
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                )

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Column(modifier = Modifier.weight(1f)) {
                        specialItems.forEachIndexed { index, product ->
                            if (index % 2 == 0) {
                                SpecialProductCard(product, index, onProductClick)
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        specialItems.forEachIndexed { index, product ->
                            if (index % 2 != 0) {
                                SpecialProductCard(product, index, onProductClick)
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Composable
fun SpecialProductCard(product: Product, index: Int, onClick: (String) -> Unit) {
    val height = if (index % 3 == 0) 280.dp else if (index % 2 == 0) 220.dp else 260.dp
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Black)
            .clickable { onClick(product.id) }
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // Dark gradient overlay
        Box(
            modifier = Modifier.fillMaxSize().background(
                Brush.verticalGradient(listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)))
            )
        )
        Column(
            modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)
        ) {
            Text(product.name, color = Color(0xFFD4AF37), fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(product.price, color = Color.White, fontSize = 14.sp)
        }
    }
}

@Composable
fun SpecialProductDetailScreen(product: Product, onBackClick: () -> Unit, onProceedToCheckout: (CartItem) -> Unit) {
    val scrollState = rememberScrollState()
    var quantity by remember { mutableStateOf(1) }
    val totalPrice = product.price.replace(Regex("[^0-9]"), "").toInt() * quantity
    
    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier.fillMaxSize().background(
                Brush.verticalGradient(listOf(Color.Black.copy(alpha = 0.4f), Color.Transparent, Color.Black.copy(alpha = 0.9f)))
            )
        )
        
        // Custom Back Button
        Box(
            modifier = Modifier
                .padding(top = 48.dp, start = 24.dp)
                .size(44.dp)
                .clip(CircleShape)
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable { onBackClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
        }
        
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            Text(
                "R E S E R V E",
                color = Color(0xFFD4AF37),
                fontSize = 12.sp,
                letterSpacing = 4.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(product.name, fontSize = 36.sp, fontWeight = FontWeight.Black, color = Color.White, lineHeight = 40.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(getUniqueProductDescription(product), fontSize = 14.sp, color = Color.LightGray, lineHeight = 22.sp)
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Quantity Selector
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(40.dp).clip(CircleShape).border(1.dp, Color.White, CircleShape).clickable { if(quantity > 1) quantity-- }, contentAlignment = Alignment.Center) {
                        Text("-", color = Color.White, fontSize = 24.sp)
                    }
                    Text(quantity.toString(), color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(horizontal = 24.dp))
                    Box(modifier = Modifier.size(40.dp).clip(CircleShape).border(1.dp, Color.White, CircleShape).clickable { quantity++ }, contentAlignment = Alignment.Center) {
                        Text("+", color = Color.White, fontSize = 24.sp)
                    }
                }
                Text("₹$totalPrice", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color(0xFFD4AF37))
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Button(
                onClick = { onProceedToCheckout(CartItem(product = product, size = "Standard", price = totalPrice / quantity, quantity = quantity)) },
                modifier = Modifier.fillMaxWidth().height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD4AF37)),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(text = "Add to Order", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }
    }
}

