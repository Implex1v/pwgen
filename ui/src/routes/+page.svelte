<script lang="ts">
    import type PasswordEvent from "../components/PasswordGenerator.svelte";
    import PasswordCard from "../components/PasswordCard.svelte";
    import PasswordGenerator from "../components/PasswordGenerator.svelte";

    let passwords: Array<string> = [];

    async function addPassword(event: CustomEvent<PasswordEvent>) {
        const tmp = [event.detail.password];
        tmp.push(...passwords);
        passwords = tmp;
    }
</script>

<p class="text-3xl py-4">Generate Password</p>

<div class="py-2">
    <PasswordGenerator on:password={addPassword} />
</div>

<p class="text-2xl py-4">History</p>

{#each passwords as password}
    <PasswordCard {password} />
{/each}
