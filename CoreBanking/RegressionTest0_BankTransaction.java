import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

public class RegressionTest0_BankTransaction {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test01");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.lang.Class<?> wildcardClass1 = coreBanking0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test02");
        java.lang.Object obj0 = new java.lang.Object();
        java.lang.Class<?> wildcardClass1 = obj0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test03");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client3 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account5 = coreBanking0.openNewAccount(client3, 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test04");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.lang.Class<?> wildcardClass2 = coreBanking0.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test05");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        io.diffblue.corebanking.client.Client client3 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account5 = coreBanking0.openNewAccount(client3, (long) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test06");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        java.lang.Class<?> wildcardClass6 = clientList5.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(clientList5);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test07");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        java.lang.Class<?> wildcardClass3 = accountList2.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test08");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.util.List<io.diffblue.corebanking.account.Account> accountList4 = coreBanking0.getAccounts();
        java.lang.Class<?> wildcardClass5 = coreBanking0.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(accountList4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test09");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.account.Account> accountList5 = coreBanking0.getAccounts();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(accountList5);
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test10");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        io.diffblue.corebanking.client.Client client3 = null;
        io.diffblue.corebanking.client.Client client4 = coreBanking0.registerNewClient(client3);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = coreBanking0.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNull(client4);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test11");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.util.List<io.diffblue.corebanking.account.Account> accountList4 = coreBanking0.getAccounts();
        io.diffblue.corebanking.client.Client client5 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account7 = coreBanking0.openNewAccount(client5, (long) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(accountList4);
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test12");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        coreBanking0.purgeCoreBanking();
        io.diffblue.corebanking.client.Client client4 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account6 = coreBanking0.openNewAccount(client4, (long) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test13");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList4 = coreBanking0.getClients();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(clientList4);
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test14");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client3 = null;
        io.diffblue.corebanking.client.Client client4 = coreBanking0.registerNewClient(client3);
        java.lang.Class<?> wildcardClass5 = coreBanking0.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
        org.junit.Assert.assertNull(client4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test15");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        coreBanking0.purgeCoreBanking();
        coreBanking0.purgeCoreBanking();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test16");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        coreBanking0.purgeCoreBanking();
        io.diffblue.corebanking.client.Client client5 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account7 = coreBanking0.openNewAccount(client5, (long) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test17");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        io.diffblue.corebanking.client.Client client3 = null;
        io.diffblue.corebanking.client.Client client4 = coreBanking0.registerNewClient(client3);
        io.diffblue.corebanking.client.Client client5 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account7 = coreBanking0.openNewAccount(client5, (long) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNull(client4);
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test18");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client3 = null;
        io.diffblue.corebanking.client.Client client4 = coreBanking0.registerNewClient(client3);
        coreBanking0.purgeCoreBanking();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
        org.junit.Assert.assertNull(client4);
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test19");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.lang.Class<?> wildcardClass5 = coreBanking0.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test20");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client6 = null;
        io.diffblue.corebanking.client.Client client7 = coreBanking0.registerNewClient(client6);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = coreBanking0.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(clientList5);
        org.junit.Assert.assertNull(client7);
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test21");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        io.diffblue.corebanking.client.Client client1 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account3 = coreBanking0.openNewAccount(client1, (long) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test22");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList3 = coreBanking0.getAccounts();
        java.util.List<io.diffblue.corebanking.account.Account> accountList4 = coreBanking0.getAccounts();
        java.lang.Class<?> wildcardClass5 = coreBanking0.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
        org.junit.Assert.assertNotNull(accountList3);
        org.junit.Assert.assertNotNull(accountList4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test23() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test23");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        coreBanking0.purgeCoreBanking();
        io.diffblue.corebanking.client.Client client5 = null;
        io.diffblue.corebanking.client.Client client6 = coreBanking0.registerNewClient(client5);
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNull(client6);
    }

    @Test
    public void test24() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test24");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        coreBanking0.purgeCoreBanking();
        java.util.List<io.diffblue.corebanking.account.Account> accountList5 = coreBanking0.getAccounts();
        java.lang.Class<?> wildcardClass6 = coreBanking0.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(accountList5);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test25() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test25");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        io.diffblue.corebanking.client.Client client5 = null;
        io.diffblue.corebanking.client.Client client6 = coreBanking0.registerNewClient(client5);
        io.diffblue.corebanking.client.Client client7 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account9 = coreBanking0.openNewAccount(client7, (long) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNull(client6);
    }

    @Test
    public void test26() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test26");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        java.util.List<io.diffblue.corebanking.client.Client> clientList3 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client4 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account6 = coreBanking0.openNewAccount(client4, (long) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(clientList3);
    }

    @Test
    public void test27() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test27");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        io.diffblue.corebanking.client.Client client3 = null;
        io.diffblue.corebanking.client.Client client4 = coreBanking0.registerNewClient(client3);
        coreBanking0.purgeCoreBanking();
        io.diffblue.corebanking.client.Client client6 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account8 = coreBanking0.openNewAccount(client6, (long) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNull(client4);
    }

    @Test
    public void test28() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test28");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.lang.Class<?> wildcardClass2 = clientList1.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test29() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test29");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.lang.String str2 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.account.Account> accountList3 = coreBanking0.getAccounts();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
        org.junit.Assert.assertNotNull(accountList3);
    }

    @Test
    public void test30() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test30");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList3 = coreBanking0.getAccounts();
        java.util.List<io.diffblue.corebanking.account.Account> accountList4 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        io.diffblue.corebanking.client.Client client6 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account8 = coreBanking0.openNewAccount(client6, (long) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
        org.junit.Assert.assertNotNull(accountList3);
        org.junit.Assert.assertNotNull(accountList4);
    }

    @Test
    public void test31() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test31");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList3 = coreBanking0.getAccounts();
        java.lang.String str4 = coreBanking0.toString();
        java.lang.String str5 = coreBanking0.toString();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
        org.junit.Assert.assertNotNull(accountList3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
    }

    @Test
    public void test32() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test32");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.util.List<io.diffblue.corebanking.account.Account> accountList4 = coreBanking0.getAccounts();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client6 = null;
        io.diffblue.corebanking.client.Client client7 = coreBanking0.registerNewClient(client6);
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(accountList4);
        org.junit.Assert.assertNotNull(clientList5);
        org.junit.Assert.assertNull(client7);
    }

    @Test
    public void test33() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test33");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList6 = coreBanking0.getClients();
        coreBanking0.purgeCoreBanking();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(clientList5);
        org.junit.Assert.assertNotNull(clientList6);
    }

    @Test
    public void test34() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test34");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.lang.String str5 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList6 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList7 = coreBanking0.getAccounts();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(clientList6);
        org.junit.Assert.assertNotNull(accountList7);
    }

    @Test
    public void test35() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test35");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client2 = null;
        io.diffblue.corebanking.client.Client client3 = coreBanking0.registerNewClient(client2);
        coreBanking0.purgeCoreBanking();
        io.diffblue.corebanking.client.Client client5 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account7 = coreBanking0.openNewAccount(client5, (long) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNull(client3);
    }

    @Test
    public void test36() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test36");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        java.lang.Class<?> wildcardClass3 = coreBanking0.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test37() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test37");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.lang.String str5 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList6 = coreBanking0.getClients();
        java.lang.Class<?> wildcardClass7 = clientList6.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(clientList6);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test38() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test38");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        io.diffblue.corebanking.client.Client client5 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account7 = coreBanking0.openNewAccount(client5, (long) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
    }

    @Test
    public void test39() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test39");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList3 = coreBanking0.getAccounts();
        java.util.List<io.diffblue.corebanking.account.Account> accountList4 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        io.diffblue.corebanking.client.Client client6 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account8 = coreBanking0.openNewAccount(client6, (long) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
        org.junit.Assert.assertNotNull(accountList3);
        org.junit.Assert.assertNotNull(accountList4);
    }

    @Test
    public void test40() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test40");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.account.Account> accountList5 = coreBanking0.getAccounts();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(accountList5);
    }

    @Test
    public void test41() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test41");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.util.List<io.diffblue.corebanking.account.Account> accountList4 = coreBanking0.getAccounts();
        java.lang.Class<?> wildcardClass5 = accountList4.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(accountList4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test42() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test42");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList6 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client7 = null;
        io.diffblue.corebanking.client.Client client8 = coreBanking0.registerNewClient(client7);
        java.util.List<io.diffblue.corebanking.client.Client> clientList9 = coreBanking0.getClients();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(clientList5);
        org.junit.Assert.assertNotNull(clientList6);
        org.junit.Assert.assertNull(client8);
        org.junit.Assert.assertNotNull(clientList9);
    }

    @Test
    public void test43() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test43");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client2 = null;
        io.diffblue.corebanking.client.Client client3 = coreBanking0.registerNewClient(client2);
        coreBanking0.purgeCoreBanking();
        java.util.List<io.diffblue.corebanking.account.Account> accountList5 = coreBanking0.getAccounts();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNull(client3);
        org.junit.Assert.assertNotNull(accountList5);
    }

    @Test
    public void test44() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test44");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client6 = null;
        io.diffblue.corebanking.client.Client client7 = coreBanking0.registerNewClient(client6);
        coreBanking0.purgeCoreBanking();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(clientList5);
        org.junit.Assert.assertNull(client7);
    }

    @Test
    public void test45() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test45");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.lang.String str5 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList6 = coreBanking0.getClients();
        java.lang.String str7 = coreBanking0.toString();
        java.lang.String str8 = coreBanking0.toString();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(clientList6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "" + "'", str7, "");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "" + "'", str8, "");
    }

    @Test
    public void test46() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test46");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList3 = coreBanking0.getAccounts();
        java.lang.String str4 = coreBanking0.toString();
        java.lang.Class<?> wildcardClass5 = coreBanking0.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
        org.junit.Assert.assertNotNull(accountList3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test47() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test47");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.lang.String str5 = coreBanking0.toString();
        java.lang.String str6 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList7 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client8 = null;
        io.diffblue.corebanking.client.Client client9 = coreBanking0.registerNewClient(client8);
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertNotNull(clientList7);
        org.junit.Assert.assertNull(client9);
    }

    @Test
    public void test48() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test48");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        coreBanking0.purgeCoreBanking();
        java.lang.String str5 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList6 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList7 = coreBanking0.getAccounts();
        java.lang.Class<?> wildcardClass8 = accountList7.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(clientList6);
        org.junit.Assert.assertNotNull(accountList7);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test49() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test49");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        coreBanking0.purgeCoreBanking();
        coreBanking0.purgeCoreBanking();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
    }

    @Test
    public void test50() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test50");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client6 = null;
        // The following exception was thrown during execution in test generation
        try {
            io.diffblue.corebanking.account.Account account8 = coreBanking0.openNewAccount(client6, 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(clientList5);
    }

    @Test
    public void test51() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test51");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList2 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList3 = coreBanking0.getAccounts();
        java.util.List<io.diffblue.corebanking.account.Account> accountList4 = coreBanking0.getAccounts();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(clientList2);
        org.junit.Assert.assertNotNull(accountList3);
        org.junit.Assert.assertNotNull(accountList4);
        org.junit.Assert.assertNotNull(clientList5);
    }

    @Test
    public void test52() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test52");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client6 = null;
        io.diffblue.corebanking.client.Client client7 = coreBanking0.registerNewClient(client6);
        io.diffblue.corebanking.client.Client client8 = null;
        io.diffblue.corebanking.client.Client client9 = coreBanking0.registerNewClient(client8);
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(clientList5);
        org.junit.Assert.assertNull(client7);
        org.junit.Assert.assertNull(client9);
    }

    @Test
    public void test53() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test53");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.util.List<io.diffblue.corebanking.account.Account> accountList4 = coreBanking0.getAccounts();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        java.lang.String str6 = coreBanking0.toString();
        coreBanking0.purgeCoreBanking();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(accountList4);
        org.junit.Assert.assertNotNull(clientList5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
    }

    @Test
    public void test54() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test54");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.lang.String str5 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList6 = coreBanking0.getClients();
        java.lang.Class<?> wildcardClass7 = coreBanking0.getClass();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertNotNull(clientList6);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test55() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test55");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client6 = null;
        io.diffblue.corebanking.client.Client client7 = coreBanking0.registerNewClient(client6);
        java.util.List<io.diffblue.corebanking.client.Client> clientList8 = coreBanking0.getClients();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str9 = coreBanking0.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(clientList5);
        org.junit.Assert.assertNull(client7);
        org.junit.Assert.assertNotNull(clientList8);
    }

    @Test
    public void test56() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test56");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        java.util.List<io.diffblue.corebanking.client.Client> clientList5 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.client.Client> clientList6 = coreBanking0.getClients();
        io.diffblue.corebanking.client.Client client7 = null;
        io.diffblue.corebanking.client.Client client8 = coreBanking0.registerNewClient(client7);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str9 = coreBanking0.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(clientList5);
        org.junit.Assert.assertNotNull(clientList6);
        org.junit.Assert.assertNull(client8);
    }

    @Test
    public void test57() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test57");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.lang.String str2 = coreBanking0.toString();
        java.lang.String str3 = coreBanking0.toString();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
    }

    @Test
    public void test58() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test58");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        coreBanking0.purgeCoreBanking();
        java.util.List<io.diffblue.corebanking.account.Account> accountList5 = coreBanking0.getAccounts();
        java.lang.String str6 = coreBanking0.toString();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(accountList5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
    }

    @Test
    public void test59() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test59");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.util.List<io.diffblue.corebanking.account.Account> accountList4 = coreBanking0.getAccounts();
        java.util.List<io.diffblue.corebanking.account.Account> accountList5 = coreBanking0.getAccounts();
        io.diffblue.corebanking.client.Client client6 = null;
        io.diffblue.corebanking.client.Client client7 = coreBanking0.registerNewClient(client6);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = coreBanking0.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertNotNull(accountList4);
        org.junit.Assert.assertNotNull(accountList5);
        org.junit.Assert.assertNull(client7);
    }

    @Test
    public void test60() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test60");
        io.diffblue.corebanking.CoreBanking coreBanking0 = new io.diffblue.corebanking.CoreBanking();
        java.util.List<io.diffblue.corebanking.client.Client> clientList1 = coreBanking0.getClients();
        java.util.List<io.diffblue.corebanking.account.Account> accountList2 = coreBanking0.getAccounts();
        coreBanking0.purgeCoreBanking();
        java.lang.String str4 = coreBanking0.toString();
        io.diffblue.corebanking.client.Client client5 = null;
        io.diffblue.corebanking.client.Client client6 = coreBanking0.registerNewClient(client5);
        java.util.List<io.diffblue.corebanking.client.Client> clientList7 = coreBanking0.getClients();
        org.junit.Assert.assertNotNull(clientList1);
        org.junit.Assert.assertNotNull(accountList2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNull(client6);
        org.junit.Assert.assertNotNull(clientList7);
    }
}

